package com.business.trip.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.business.trip.model.BusinessTripReimbursement;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class BusinessTripReimbursementAssetRender extends BaseAssetRenderer {
	private BusinessTripReimbursement _businessTripReimbursement;   
	public static final String CLASS_NAME = BusinessTripReimbursement.class.getName();   
	public BusinessTripReimbursementAssetRender(BusinessTripReimbursement businessTripReimbursement) {
		_businessTripReimbursement = businessTripReimbursement;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public long getClassPK() {
		return _businessTripReimbursement.getBusinessTripReimbursementId();
	}

	@Override
	public long getGroupId() {
		return _businessTripReimbursement.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return _businessTripReimbursement.getTicketNo();
	}

	@Override
	public String getTitle(Locale locale) {
		return _businessTripReimbursement.getTicketNo();
	}

	@Override
	public long getUserId() {
		return _businessTripReimbursement.getUserId();
	}

	@Override
	public String getUserName() {
		return _businessTripReimbursement.getUserName();
	}

	@Override
	public String getUuid() {
		try {
			return String.valueOf(_businessTripReimbursement.getUserUuid());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse, String template) throws Exception {
		// TODO Auto-generated method stub
		return "/html/businessTripReimbursement/view.jsp";
	}

}
