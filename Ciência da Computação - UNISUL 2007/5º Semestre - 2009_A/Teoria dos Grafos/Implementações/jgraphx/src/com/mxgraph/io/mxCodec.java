/**
 * $Id: mxCodec.java,v 1.19 2009/01/15 09:40:02 gaudenz Exp $
 * Copyright (c) 2006, Gaudenz Alder
 */
package com.mxgraph.io;

import java.util.Hashtable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxCellPath;
import com.mxgraph.model.mxICell;
import com.mxgraph.util.mxUtils;

/**
 * XML codec for Java object graphs. In order to resolve forward references
 * when reading files the XML document that contains the data must be passed
 * to the constructor.
 */
public class mxCodec
{

	/**
	 * Holds the owner document of the codec.
	 */
	protected Document document;

	/**
	 * Maps from IDs to objects.
	 */
	protected Hashtable objects = new Hashtable();

	/**
	 * Specifies if default values should be encoded. Default is false.
	 */
	protected boolean encodeDefaults = false;

	/**
	 * Constructs an XML encoder/decoder with a new owner document.
	 */
	public mxCodec()
	{
		this(mxUtils.createDocument());
	}

	/**
	 * Constructs an XML encoder/decoder for the specified owner document.
	 * 
	 * @param document Optional XML document that contains the data. If no document
	 * is specified then a new document is created using mxUtils.createDocument
	 */
	public mxCodec(Document document)
	{
		if (document == null)
		{
			document = mxUtils.createDocument();
		}

		this.document = document;
	}

	/**
	 * Returns if default values of member variables should be encoded.
	 */
	public boolean isEncodeDefaults()
	{
		return encodeDefaults;
	}

	/**
	 * Sets if default values of member variables should be encoded.
	 */
	public void setEncodeDefaults(boolean encodeDefaults)
	{
		this.encodeDefaults = encodeDefaults;
	}

	/**
	 * Returns the object lookup table.
	 */
	public Hashtable getObjects()
	{
		return objects;
	}
	
	/**
	 * Returns the owner document of the codec.
	 * 
	 * @return Returns the owner document.
	 */
	public Document getDocument()
	{
		return document;
	}

	/**
	 * Assoiates the given object with the given ID.
	 * 
	 * @param id ID for the object to be associated with.
	 * @param object Object to be associated with the ID.
	 * @return Returns the given object.
	 */
	public Object putObject(String id, Object object)
	{
		return objects.put(id, object);
	}

	/**
	 * Returns the decoded object for the element with the specified ID in
	 * {@link #document}. If the object is not known then {@link #lookup(String)}
	 * is used to find an object. If no object is found, then the element with
	 * the respective ID from the document is parsed using {@link #decode(Node)}.
	 * 
	 * @param id ID of the object to be returned.
	 * @return Returns the object for the given ID.
	 */
	public Object getObject(String id)
	{
		Object obj = null;

		if (id != null)
		{
			obj = objects.get(id);

			if (obj == null)
			{
				obj = lookup(id);

				if (obj == null)
				{
					Node node = getElementById(id);

					if (node != null)
					{
						obj = decode(node);
					}
				}
			}
		}

		return obj;
	}

	/**
	 * Hook for subclassers to implement a custom lookup mechanism for cell IDs.
	 * This implementation always returns null.
	 * 
	 * @param id ID of the object to be returned.
	 * @return Returns the object for the given ID.
	 */
	public Object lookup(String id)
	{
		return null;
	}

	/**
	 * Returns the element with the given ID from the document.
	 * 
	 * @param id ID of the element to be returned.
	 * @return Returns the element for the given ID.
	 */
	public Node getElementById(String id)
	{
		return getElementById(id, null);
	}

	/**
	 * Returns the element with the given ID from <document>. The optional attr
	 * argument specifies the name of the ID attribute. Default is "id". The
	 * XPath expression used to find the element is //*[@attr='arg'] where attr
	 * is the name of the ID attribute and arg is the given id.
	 * 
	 * Parameters:
	 * 
	 * id - String that contains the ID.
	 * attr - Optional string for the attributename. Default is id.
	 */
	public Node getElementById(String id, String attr)
	{
		if (attr == null)
		{
			attr = "id";
		}

		String expr = "//*[@" + attr + "='" + id + "']";

		return mxUtils.selectSingleNode(document, expr);
	}

	/**
	 * Returns the ID of the specified object. This implementation calls
	 * <reference> first and if that returns null handles the object as an
	 * <mxCell> by returning their IDs using <mxCell.getId>. If no ID exists for
	 * the given cell, then an on-the-fly ID is generated using
	 * <mxCellPath.create>.
	 * 
	 * @param obj Object to return the ID for.
	 * @return Returns the ID for the given object.
	 */
	public String getId(Object obj)
	{
		String id = null;

		if (obj != null)
		{
			id = reference(obj);

			if (id == null && obj instanceof mxICell)
			{
				id = ((mxICell) obj).getId();

				if (id == null)
				{
					// Uses an on-the-fly Id
					id = mxCellPath.create((mxICell) obj);

					if (id.length() == 0)
					{
						id = "root";
					}
				}
			}
		}

		return id;
	}

	/**
	 * Hook for subclassers to implement a custom method for retrieving IDs from
	 * objects. This implementation always returns null.
	 * 
	 * @param obj Object whose ID should be returned.
	 * @return Returns the ID for the given object.
	 */
	public String reference(Object obj)
	{
		return null;
	}

	/**
	 * Encodes the specified object and returns the resulting XML node.
	 * 
	 * @param obj Object to be encoded.
	 * @return Returns an XML node that represents the given object.
	 */
	public Node encode(Object obj)
	{
		Node node = null;

		if (obj != null)
		{
			String name = mxCodecRegistry.getName(obj.getClass());
			mxObjectCodec enc = mxCodecRegistry.getCodec(name);

			if (enc != null)
			{
				node = enc.encode(this, obj);
			}
			else
			{
				if (obj instanceof Node)
				{
					node = ((Node) obj).cloneNode(true);
				}
				else
				{
					System.err.println("No codec for " + name);
				}
			}
		}

		return node;
	}

	/**
	 * Decodes the given XML node using {@link #decode(Node, Object)}.
	 * 
	 * @param node XML node to be decoded.
	 * @return Returns an object that represents the given node.
	 */
	public Object decode(Node node)
	{
		return decode(node, null);
	}

	/**
	 * Decodes the given XML node. The optional "into" argument specifies an
	 * existing object to be used. If no object is given, then a new
	 * instance is created using the constructor from the codec.
	 * 
	 * The function returns the passed in object or the new instance if no
	 * object was given.
	 * 
	 * @param node XML node to be decoded.
	 * @param into Optional object to be decodec into.
	 * @return Returns an object that represents the given node.
	 */
	public Object decode(Node node, Object into)
	{
		Object obj = null;

		if (node != null && node.getNodeType() == Node.ELEMENT_NODE)
		{
			mxObjectCodec codec = mxCodecRegistry.getCodec(node.getNodeName());

			try
			{
				if (codec != null)
				{
					obj = codec.decode(this, node, into);
				}
				else
				{
					obj = node.cloneNode(true);
					((Element) obj).removeAttribute("as");
				}
			}
			catch (Exception e)
			{
				System.err.println("Cannot decode " + node.getNodeName() + ": "
						+ e.getMessage());
				e.printStackTrace();
			}
		}

		return obj;
	}

	/**
	 * Encoding of cell hierarchies is built-into the core, but is a
	 * higher-level function that needs to be explicitely used by the
	 * respective object encoders (eg. <mxModelCodec>, <mxChildChangeCodec>
	 * and <mxRootChangeCodec>). This implementation writes the given cell
	 * and its children as a (flat) sequence into the given node. The
	 * children are not encoded if the optional isIncludeChildren is false.
	 * The function is in charge of adding the result into the given node
	 * and has no return value.
	 * 
	 * @param cell mxCell to be encoded.
	 * @param node Parent XML node to add the encoded cell into.
	 * @param isIncludeChildren Boolean indicating if the method
	 * should include all descendents.
	 */
	public void encodeCell(mxICell cell, Node node, boolean isIncludeChildren)
	{
		node.appendChild(this.encode(cell));

		if (isIncludeChildren)
		{
			int childCount = cell.getChildCount();

			for (int i = 0; i < childCount; i++)
			{
				encodeCell(cell.getChildAt(i), node, isIncludeChildren);
			}
		}
	}

	/**
	 * Decodes cells that have been encoded using inversion, ie. where the
	 * user object is the enclosing node in the XML, and restores the group
	 * and graph structure in the cells. Returns a new <mxCell> instance
	 * that represents the given node.
	 * 
	 * @param node XML node that contains the cell data.
	 * @param isRestoreStructures Boolean indicating whether the graph
	 * structure should be restored by calling insert and insertEdge on the
	 * parent and terminals, respectively.
	 * @return Graph cell that represents the given node.
	 */
	public mxICell decodeCell(Node node, boolean isRestoreStructures)
	{
		mxICell cell = null;

		if (node != null && node.getNodeType() == Node.ELEMENT_NODE)
		{
			// Hardcodes the decoder because the name of the
			// node is not mxCell, but the name of the user
			// object inside the cell (inversion).
			String name = mxCodecRegistry.getName(mxCell.class);
			mxObjectCodec decoder = mxCodecRegistry.getCodec(name);
			cell = (mxICell) decoder.decode(this, node);

			if (isRestoreStructures)
			{
				mxICell parent = cell.getParent();

				if (parent != null)
				{
					parent.insert(cell);
				}

				mxICell source = cell.getTerminal(true);

				if (source != null)
				{
					source.insertEdge(cell, true);
				}

				mxICell target = cell.getTerminal(false);

				if (target != null)
				{
					target.insertEdge(cell, false);
				}
			}
		}
		return cell;
	}

	/**
	 * Sets the attribute on the specified node to value. This is a
	 * helper method that makes sure the attribute and value arguments
	 * are not null.
	 *
	 * @param node XML node to set the attribute for.
	 * @param attribute Name of the attribute whose value should be set.
	 * @param value New value of the attribute.
	 */
	public static void setAttribute(Node node, String attribute, Object value)
	{
		if (node.getNodeType() == Node.ELEMENT_NODE && attribute != null
				&& value != null)
		{
			((Element) node).setAttribute(attribute, String.valueOf(value));
		}
	}

}
