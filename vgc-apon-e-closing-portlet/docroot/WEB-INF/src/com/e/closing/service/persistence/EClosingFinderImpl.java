package com.e.closing.service.persistence;

import com.e.closing.model.EClosing;
import com.e.closing.model.custom.KaleoInstanceObject;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.ArrayList;
import java.util.List;

public class EClosingFinderImpl extends BasePersistenceImpl implements EClosingFinder {

	public int findEclosingAllByKaleoInstanceId(long pk,String tabs2) throws SystemException {
		  List<KaleoInstanceObject> result = new ArrayList<KaleoInstanceObject>();
			Session session = null;
			int count = 0;
			try {
				session = openSession();
				StringBuilder query = new StringBuilder();
				
				query.append("select max(kaleoinstanceid) AS COUNT_VALUE from KALEOINSTANCE where classpk = "+pk+" and classname = 'com.e.closing.model.EClosing' ");
				if("pending".equals(tabs2)){
					query.append("and completed <> 1");
				}else if ("completed".equals(tabs2)) {
					query.append("and completed = 1");
				}
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
				
				return count = ((Long) q.uniqueResult()).intValue();
			} catch (Exception e) {
				return 0;
			} finally {
				closeSession(session);
			}
	}
	
	public List<EClosing> getEclosingByStaffcode(String staffcode) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append("select * from VGCAPON_ECLOSING where staffcode = "+staffcode+" and subprocesstype = 'E-Closing' ");

			Query q = session.createQuery(query.toString());

			return (List<EClosing>) q.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
}
