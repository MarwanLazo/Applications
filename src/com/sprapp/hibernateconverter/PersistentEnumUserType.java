package com.sprapp.hibernateconverter;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public abstract class PersistentEnumUserType<T extends PersistentEnum> implements UserType {
	
	@Override
	public Object assemble (Serializable arg0 , Object arg1) throws HibernateException {
		return arg0;
	}
	
	@Override
	public Object deepCopy (Object arg0) throws HibernateException {
		return arg0;
	}
	
	@Override
	public Serializable disassemble (Object arg0) throws HibernateException {
		
		return (Serializable) arg0;
	}
	
	@Override
	public boolean equals (Object arg0 , Object arg1) throws HibernateException {
		
		return arg0 == arg1;
	}
	
	@Override
	public int hashCode (Object arg0) throws HibernateException {
		
		return arg0 == null ? 0 : arg0.hashCode();
	}
	
	@Override
	public boolean isMutable () {
		
		return false;
	}
	
	@Override
	public Object nullSafeGet (ResultSet arg0 , String[] arg1 , SessionImplementor arg2 , Object arg3) throws HibernateException , SQLException {
		int id = arg0.getInt(arg1[0]);
		if (arg0.wasNull()) {
			return null;
		}
		
		for (Object value : returnedClass().getEnumConstants()) {
			if (id == ((PersistentEnum) value).getId()) {
				return value;
			}
		}
		throw new IllegalStateException("Unknown " + returnedClass().getSimpleName() + " id");
		
	}
	
	@Override
	public void nullSafeSet (PreparedStatement arg0 , Object arg1 , int arg2 , SessionImplementor arg3) throws HibernateException , SQLException {
		if (arg1 == null) {
			arg0.setNull(arg2, Types.INTEGER);
		} else {
			arg0.setInt(arg2, ((PersistentEnum) arg1).getId());
		}
		
	}
	
	@Override
	public Object replace (Object arg0 , Object arg1 , Object arg2) throws HibernateException {
		
		return arg0;
	}
	
	@Override
	public abstract Class<?> returnedClass ();
	
	@Override
	public int[] sqlTypes () {
		return new int[] { Types.INTEGER };
	}
}
