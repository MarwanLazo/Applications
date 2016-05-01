package com.sprapp.hibernateconverter;

import com.sprapp.general.Status;

public class SatusUserType extends PersistentEnumUserType<Status> {
	
	@Override
	public Class<Status> returnedClass () {
		return Status.class;
	}
	
}
