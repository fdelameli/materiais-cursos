/**
 * $Id: mxEventObject.java,v 1.1 2009/03/20 08:56:45 gaudenz Exp $
 * Copyright (c) 2007, Gaudenz Alder
 */
package com.mxgraph.util;

/**
 * Base class for objects that dispatch named events.
 */
public class mxEventObject
{
	/**
	 * 
	 */
	protected static final Object[] EMPTY_ARRAY = new Object[] {};

	/**
	 * Holds the consumed state of the event. Default is false.
	 */
	protected boolean consumed = false;

	/**
	 * Holds the arguments associated with this event object.
	 */
	protected Object[] args;

	/**
	 * Constructs a new event source using this as the source object.
	 */
	public mxEventObject()
	{
		this(EMPTY_ARRAY);
	}

	/**
	 * Constructs a new event source for the given source object.
	 */
	public mxEventObject(Object[] args)
	{
		this.args = args;
	}

	/**
	 * Returns true if the event has been consumed.
	 */
	public boolean isConsumed()
	{
		return consumed;
	}

	/**
	 * Consumes the event.
	 */
	public void consume()
	{
		consumed = true;
	}

	/**
	 * Dispatches the given event name, passing all arguments after the given
	 * name to the registered listeners for the event.
	 */
	public Object[] getArgs()
	{
		return args;
	}

	/**
	 * 
	 */
	public int getArgCount()
	{
		return args.length;
	}

	/**
	 * 
	 */
	public Object getArgAt(int index)
	{
		return args[index];
	}

}
