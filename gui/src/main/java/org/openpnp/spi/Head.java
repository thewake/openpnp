/*
 	Copyright (C) 2011 Jason von Nieda <jason@vonnieda.org>
 	
 	This file is part of OpenPnP.
 	
	OpenPnP is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    OpenPnP is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with OpenPnP.  If not, see <http://www.gnu.org/licenses/>.
 	
 	For more information about OpenPnP visit http://openpnp.org
 */

package org.openpnp.spi;

import java.util.List;

import org.openpnp.model.Identifiable;


/**
 * A Head is a movable group of components attached to a Machine. Components
 * which can be attached consist of Nozzles, Actuators and Cameras. A Head
 * itself is not directly movable, but can be moved by moving any one of it's
 * components. When any attached component is moved in (at least) X or Y, it is
 * expected that all components attached to the Head also move in the same
 * axes.
 */
public interface Head extends Identifiable, WizardConfigurable {
    /**
     * Get a list of Nozzles that are attached to this head.
     * @return
     */
    public List<Nozzle> getNozzles();
    
    /**
     * Get the Nozzle attached to this Head that has the specified id.
     * @param id
     * @return
     */
    public Nozzle getNozzleById(String id);
    
	/**
	 * Get a list of Actuators that are attached to this Head.
	 * @return
	 */
	public List<Actuator> getActuators();
	
	/**
	 * Get the Actuator attached to this Head that has the specified id.
	 * @param id
	 * @return
	 */
	public Actuator getActuatorById(String id);
	
	/**
	 * Get a list of Cameras that are attached to this Head.
	 * @return
	 */
	public List<Camera> getCameras();
	
	/**
	 * Get the Camera attached to this Head that has the specified id.
	 * @param id
	 * @return
	 */
	public Camera getCameraById(String id);
	
    /**
     * Directs the Head to move to it's home position and to move any
     * attached devices to their home positions. 
     */
    void home() throws Exception;
    
    /**
     * Move all devices on the Head to their Safe Z position. This is a
     * position which should make it safe to move the Head in X and Y without
     * crashing any of the attached devices. Typically this call should only
     * produce motion in the Z axis.
     */
    void moveToSafeZ() throws Exception;
}
