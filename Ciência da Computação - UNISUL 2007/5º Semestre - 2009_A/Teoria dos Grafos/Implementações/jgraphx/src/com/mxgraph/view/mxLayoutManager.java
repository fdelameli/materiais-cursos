package com.mxgraph.view;

import java.awt.Point;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.model.mxIGraphModel;
import com.mxgraph.model.mxGraphModel.mxChildChange;
import com.mxgraph.model.mxGraphModel.mxGeometryChange;
import com.mxgraph.model.mxGraphModel.mxRootChange;
import com.mxgraph.model.mxGraphModel.mxTerminalChange;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource;
import com.mxgraph.util.mxUndoableEdit;
import com.mxgraph.util.mxUtils;

public class mxLayoutManager extends mxEventSource
{

	/**
	 * Defines the type of the source or target terminal. The type is a string
	 * passed to mxCell.is to check if the rule applies to a cell.
	 */
	protected mxGraph graph;

	/**
	 * Optional string that specifies the value of the attribute to be passed
	 * to mxCell.is to check if the rule applies to a cell.
	 */
	protected boolean enabled;

	/**
	 * Optional string that specifies the attributename to be passed to
	 * mxCell.is to check if the rule applies to a cell.
	 */
	protected boolean bubbling;

	/**
	 * 
	 */
	protected mxIEventListener undoHandler = new mxIEventListener()
	{
		public void invoke(Object source, mxEventObject evt)
		{
			beforeUndo((mxUndoableEdit) evt.getArgAt(0));
		}
	};

	/**
	 * 
	 */
	protected mxIEventListener moveHandler = new mxIEventListener()
	{
		public void invoke(Object source, mxEventObject evt)
		{
			if (isEnabled())
			{
				cellsMoved((Object[]) evt.getArgAt(0), (Point) evt.getArgAt(2));
			}
		}
	};

	/**
	 * 
	 */
	public mxLayoutManager(mxGraph graph)
	{
		setGraph(graph);
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean value)
	{
		enabled = value;
	}

	/**
	 * @return the bubbling
	 */
	public boolean isBubbling()
	{
		return bubbling;
	}

	/**
	 * @param bubbling the bubbling to set
	 */
	public void setBubbling(boolean value)
	{
		bubbling = value;
	}

	/**
	 * @return the graph
	 */
	public mxGraph getGraph()
	{
		return graph;
	}

	/**
	 * @param graph the graph to set
	 */
	public void setGraph(mxGraph graph)
	{
		if (this.graph != null)
		{
			mxIGraphModel model = this.graph.getModel();
			model.removeListener(undoHandler);
			this.graph.removeListener(moveHandler);
		}

		this.graph = graph;

		if (this.graph != null)
		{
			mxIGraphModel model = this.graph.getModel();
			model.addListener(mxEvent.BEFORE_UNDO, undoHandler);
			this.graph.addListener(mxEvent.MOVE_CELLS, this.moveHandler);
		}
	}

	/**
	 * 
	 */
	protected mxIGraphLayout getLayout(Object parent)
	{
		return null;
	}

	/**
	 * 
	 */
	protected void cellsMoved(Object[] cells, Point location)
	{
		if (cells != null && location != null)
		{
			mxIGraphModel model = getGraph().getModel();

			// Checks if a layout exists to take care of the moving
			for (int i = 0; i < cells.length; i++)
			{
				mxIGraphLayout layout = getLayout(model.getParent(cells[i]));

				if (layout != null)
				{
					layout.moveCell(cells[i], location.x, location.y);
				}
			}
		}
	}

	/**
	 * 
	 */
	protected void beforeUndo(mxUndoableEdit edit)
	{
		Collection cells = getCellsForChanges(edit.getChanges());
		mxIGraphModel model = getGraph().getModel();

		if (isBubbling())
		{
			Object[] tmp = mxGraphModel.getParents(model, cells.toArray());

			while (tmp.length > 0)
			{
				cells.addAll(Arrays.asList(tmp));
				tmp = mxGraphModel.getParents(model, tmp);
			}
		}

		layoutCells(mxUtils.sortCells(cells, false).toArray());
	}

	/**
	 * 
	 */
	protected Collection getCellsForChanges(List changes)
	{
		Set result = new HashSet();

		Iterator it = changes.iterator();

		while (it.hasNext())
		{
			Object change = it.next();

			if (change instanceof mxRootChange)
			{
				return new HashSet();
			}
			else
			{
				result.addAll(getCellsForChange(change));
			}
		}

		return result;
	}

	/**
	 * 
	 */
	protected Collection getCellsForChange(Object change)
	{
		mxIGraphModel model = getGraph().getModel();
		Set result = new HashSet();

		if (change instanceof mxChildChange)
		{
			mxChildChange cc = (mxChildChange) change;
			Object parent = model.getParent(cc.getChild());

			if (cc.getChild() != null)
			{
				result.add(cc.getChild());
			}

			if (parent != null)
			{
				result.add(parent);
			}

			if (cc.getPrevious() != null)
			{
				result.add(cc.getPrevious());
			}
		}
		else if (change instanceof mxTerminalChange
				|| change instanceof mxGeometryChange)
		{
			Object cell = (change instanceof mxTerminalChange) ? ((mxTerminalChange) change)
					.getCell()
					: ((mxGeometryChange) change).getCell();

			if (cell != null)
			{
				result.add(cell);
				Object parent = model.getParent(cell);

				if (parent != null)
				{
					result.add(parent);
				}
			}
		}

		return result;
	}

	/**
	 * 
	 */
	protected void layoutCells(Object[] cells)
	{
		if (cells.length > 0)
		{
			// Invokes the layouts while removing duplicates
			mxIGraphModel model = getGraph().getModel();

			model.beginUpdate();
			try
			{
				for (int i = 0; i < cells.length; i++)
				{
					if (cells[i] != model.getRoot())
					{
						executeLayout(getLayout(cells[i]), cells[i]);
					}
				}

				fireEvent(mxEvent.LAYOUT_CELLS, new mxEventObject(
						new Object[] { cells }));
			}
			finally
			{
				model.endUpdate();
			}
		}
	}

	/**
	 * 
	 */
	protected void executeLayout(mxIGraphLayout layout, Object parent)
	{
		if (layout != null && parent != null)
		{
			layout.execute(parent);
		}
	}

	/**
	 * 
	 */
	public void destroy()
	{
		setGraph(null);
	}

}
