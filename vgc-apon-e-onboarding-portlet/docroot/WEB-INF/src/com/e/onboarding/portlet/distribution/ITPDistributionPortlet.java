package com.e.onboarding.portlet.distribution;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.e.onboarding.model.Distribution;
import com.e.onboarding.service.DistributionLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DistributionPortlet
 */
public class ITPDistributionPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String distributionType=PropsUtil.get("vgc.apon.distribution.type.itp");
		renderRequest.setAttribute("distributionType",distributionType);
		super.doView(renderRequest, renderResponse);
	}
	
	public void deleteDistribution(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		long distributionId = ParamUtil.getLong(actionRequest,
				"distributionId",0);
		long[] distributionIds = ParamUtil.getLongValues(actionRequest, "distributionIds");
		
		try {
			if(distributionId>0) {
				if(DistributionLocalServiceUtil.fetchDistribution(distributionId)!=null) {
					DistributionLocalServiceUtil.deleteDistribution(distributionId);
				}				
			}
			for(long id:distributionIds) {
				if(DistributionLocalServiceUtil.fetchDistribution(id)!=null) {
					DistributionLocalServiceUtil.deleteDistribution(id);
				}
			}
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		String cmd = ParamUtil.getString(actionRequest, "cmd");
		if (Constants.SEARCH.equals(cmd)) {
			this.query(actionRequest, actionResponse);
		}
		super.processAction(actionRequest, actionResponse);
	}

	// Execute the query for the query condition
	public void query(ActionRequest actionRequest, ActionResponse actionResponse) {
		String distributionType=PropsUtil.get("vgc.apon.distribution.type.itp");
		String name = actionRequest.getParameter("name");
		String emailAddress = actionRequest.getParameter("emailAddress");
		actionResponse.setRenderParameter("distributionType", distributionType);
		actionResponse.setRenderParameter("name", name);
		actionResponse.setRenderParameter("emailAddress", emailAddress);
		actionResponse.setRenderParameter("mvcPath", "/html/distribution/view.jsp");
	}
	
	public void addDistribution(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			String name = actionRequest.getParameter("addName");
			String emailAddress = actionRequest.getParameter("addEmailAddress");
			String comments = actionRequest.getParameter("addComments");
			String type = ParamUtil.getString(actionRequest, "type");
			Distribution distribution = DistributionLocalServiceUtil.fetchByemailAddress(emailAddress);
			if(Validator.isNull(distribution)) {
				long distributionId = CounterLocalServiceUtil.increment(Distribution.class.getName(), 1);
				distribution = DistributionLocalServiceUtil.createDistribution(distributionId);
			}
			distribution.setName(name);
			distribution.setEmailAddress(emailAddress);
			distribution.setComments(comments);
			distribution.setType(type);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Distribution.class.getName(), actionRequest);
			DistributionLocalServiceUtil.addDistrition(distribution,serviceContext);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}

	}

}
