/**
 * $Id: mxEventSource.java,v 1.6 2009/04/01 21:49:21 gaudenz Exp $
 * Copyright (c) 2007, Gaudenz Alder
 */
package com.mxgraph.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for objects that dispatch named events.
 */
public class mxEventSource
{

	/**
	 * Defines the requirements for an object that listens to an event source.
	 */
	public interface mxIEventListener
	{

		/**
		 * Called when the graph model has changed.
		 * 
		 * @param source Reference to the source of the event.
		 */
		void invoke(Object source, mxEventObject evt);

	}

	/**
	 * Holds the event names and associated listeners in an array. The array
	 * contains the event name followed by the respective listener for each
	 * registered listener.
	 */
	protected transient List eventListeners = null;

	/**
	 * Holds the source object for this event source.
	 */
	protected Object eventSource;

	/**
	 * Specifies if events can be fired. Default is true.
	 */
	protected boolean eventsEnabled = true;

	/**
	 * Constructs a new event source using this as the source object.
	 */
	public mxEventSource()
	{
		this(null);
	}

	/**
	 * Constructs a new event source for the given source object.
	 */
	public mxEventSource(Object source)
	{
		setEventSource(source);
	}

	/**
	 * 
	 */
	public Object getEventSource()
	{
		return eventSource;
	}

	/**
	 * 
	 */
	public void setEventSource(Object value)
	{
		this.eventSource = value;
	}

	/**
	 * 
	 */
	public boolean isEventsEnabled()
	{
		return eventsEnabled;
	}

	/**
	 * 
	 */
	public void setEventsEnabled(boolean eventsEnabled)
	{
		this.eventsEnabled = eventsEnabled;
	}

	/**
	 * Binds the specified function to the given event name. If no event name
	 * is given, then the listener is registered for all events.
	 */
	public void addListener(String eventName, mxIEventListener listener)
	{
		if (eventListeners == null)
		{
			eventListeners = new ArrayList();
		}

		eventListeners.add(eventName);
		eventListeners.add(listener);
	}

	/**
	 * Function: removeListener
	 *
	 * Removes all occurances of the given listener from the list of listeners.
	 */
	public void removeListener(mxIEventListener listener)
	{
		removeListener(listener, null);
	}

	/**
	 * Function: removeListener
	 *
	 * Removes all occurances of the given listener from the list of listeners.
	 */
	public void removeListener(mxIEventListener listener, String eventName)
	{
		if (eventListeners != null)
		{
			for (int i = eventListeners.size() - 2; i > 1; i -= 2)
			{
				if (eventListeners.get(i + 1) == listener
						&& (eventName == null || String.valueOf(
								eventListeners.get(i)).equals(eventName)))
				{
					eventListeners.remove(i + 1);
					eventListeners.remove(i);
				}
			}
		}
	}

	/**
	 * Dispatches the given event name with this object as the event source and no
	 * additional arguments.
	 */
	public void fireEvent(String eventName)
	{
		fireEvent(eventName, null);
	}

	/**
	 * Dispatches the given event name with this object as the event source, passing
	 * all arguments after the given name to the registered listeners for the event.
	 */
	public void fireEvent(String eventName, mxEventObject evt)
	{
		fireEvent(eventName, evt, null);
	}

	/**
	 * Dispatches the given event name, passing all arguments after the given
	 * name to the registered listeners for the event.
	 */
	public void fireEvent(String eventName, mxEventObject evt, Object source)
	{
		if (eventListeners != null && !eventListeners.isEmpty()
				&& isEventsEnabled())
		{
			if (evt == null)
			{
				evt = new mxEventObject();
			}

			if (source == null)
			{
				source = getEventSource();
			}

			if (source == null)
			{
				source = this;
			}

			for (int i = 0; i < eventListeners.size(); i += 2)
			{
				String listen = (String) eventListeners.get(i);

				if (listen == null || listen.equals(eventName))
				{
					((mxIEventListener) eventListeners.get(i + 1)).invoke(
							source, evt);
				}
			}
		}
	}

}
