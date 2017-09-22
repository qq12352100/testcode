/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.company.car.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.company.car.model.CompanyCarManagement;
import com.company.car.service.CompanyCarManagementLocalServiceUtil;
import com.company.car.service.base.CompanyCarManagementLocalServiceBaseImpl;
import com.company.car.util.CompanyCarConstants;
import com.company.car.util.ContractTypeEnum;
import com.company.car.util.EmployeeSubGroupIDPersonalGradeEnum;
import com.company.car.util.FunctionGradeEnum;
import com.company.car.util.PersonalGradeEnum;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.vgc.apon.model.SAPUser;
import com.vgc.apon.service.SAPUserLocalServiceUtil;

/**
 * The implementation of the company car management local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vgc.apon.service.CompanyCarManagementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author
 * @see com.vgc.apon.service.base.CompanyCarManagementLocalServiceBaseImpl
 * @see com.vgc.apon.service.CompanyCarManagementLocalServiceUtil
 */
public class CompanyCarManagementLocalServiceImpl
	extends CompanyCarManagementLocalServiceBaseImpl {
	private static Log log = LogFactoryUtil
			.getLog(CompanyCarManagementLocalServiceImpl.class);
	
	/**
	 * Import the excel info to the database
	 */
	public List<CompanyCarManagement> importCompanyCarManagement(List<Map<String,String>> list)
		throws SystemException {
		companyCarManagementPersistence.removeAll();
		for(int i=1;i<list.size();i++) {
			Map<String,String> map = list.get(i);
			String carNo = map.get("c0");
			if(Validator.isNotNull(carNo)) {
				long companyCarManagementId = counterLocalService.increment(CompanyCarManagement.class.getName(), 1);
				CompanyCarManagement com = companyCarManagementPersistence.create(companyCarManagementId);
				com.setCreateDate(new Date());
				com.setCarNo(carNo);
				com.setCarType(map.get("c1"));
				com.setContractType(map.get("c2"));
				com.setGradeType(map.get("c3"));
				com.setGrade(map.get("c4"));
				com.setCarBrand(map.get("c5"));
				com.setCarModel(map.get("c6"));
				com.setCarCategory(map.get("c7"));
				companyCarManagementPersistence.update(com);			
			}
		}
		return companyCarManagementPersistence.findAll();
	}
	
	/**
	 * Query the CompanyCarManagement
	 */
	public List<CompanyCarManagement> findByC_C_C_C(String carType,String contractType,String carBrand,String carCategory)
		throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CompanyCarManagement.class);
		if (Validator.isNotNull(carType)) {
			query.add(RestrictionsFactoryUtil.eq("carType", carType));
		}
		if (Validator.isNotNull(contractType)) {
			query.add(PropertyFactoryUtil.forName("contractType").eq(contractType));
		}
		if (Validator.isNotNull(carBrand)) {
			query.add(RestrictionsFactoryUtil.ilike("carBrand", "%" + carBrand + "%"));		
		}
		if (Validator.isNotNull(carCategory)) {
			query.add(PropertyFactoryUtil.forName("carCategory").eq(carCategory));
		}
		return dynamicQuery(query);
	}
	
	/**
	 * Query the count
	 */
	public long findCountByC_C_C_C(String carType,String contractType,String carBrand,String carCategory)
		throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CompanyCarManagement.class);
		if (Validator.isNotNull(carType)) {
			query.add(RestrictionsFactoryUtil.eq("carType", carType));
		}
		if (Validator.isNotNull(contractType)) {
			query.add(PropertyFactoryUtil.forName("contractType").eq(contractType));
		}
		if (Validator.isNotNull(carBrand)) {
			query.add(RestrictionsFactoryUtil.ilike("carBrand", "%" + carBrand + "%"));		
		}
		if (Validator.isNotNull(carCategory)) {
			query.add(PropertyFactoryUtil.forName("carCategory").eq(carCategory));
		}
		return dynamicQueryCount(query);
	}
	
	/**
	 * Query the Car Category level according the grade
	 */
	public String findCartegoryByC_G_G(String carType,String gradeType,String grade)
		throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CompanyCarManagement.class);
		String carCategory = "7";
		if (Validator.isNotNull(carType)) {
			query.add(PropertyFactoryUtil.forName("carType").eq(carType));
		}
		if (Validator.isNotNull(gradeType)) {
			query.add(PropertyFactoryUtil.forName("gradeType").eq(gradeType));
		}
		if (Validator.isNotNull(grade)) {
			query.add(PropertyFactoryUtil.forName("grade").eq(grade));
		}else {
			return carCategory;
		}		
		List<CompanyCarManagement> list= dynamicQuery(query);
		if(list==null ||list.size()==0) {
			return carCategory;
		}else {
			for(CompanyCarManagement cc:list) {
				if(cc.getCarCategory().compareTo(carCategory)<0) {
					carCategory = cc.getCarCategory();
				}
			}
		}
		return carCategory;
	}
	
	/**
	 * Query the CompanyCarManagement
	 */
	public List<CompanyCarManagement> findByS_F_C_C_C(String staffCode,int childrenNumber,String carType,String carCategory,String carBrand)
		throws SystemException {
		SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(staffCode);
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CompanyCarManagement.class);
		query = this.getCompanyCarCategoryQuery(query, sapUser, childrenNumber, carType, carCategory, carBrand);
		if(CompanyCarConstants.FIRST_COMPANY_CAR.equals(carType)) {
			if(sapUser!=null) {
				String personalTitle=sapUser.getPersonalTitle();
				String fgCarCategory = this.findCartegoryByC_G_G(carType, CompanyCarConstants.FUNCTION_GRADE, sapUser.getSg());
				String pgCarCategory = this.findCartegoryByC_G_G(carType, CompanyCarConstants.PERSONAL_GRADE, EmployeeSubGroupIDPersonalGradeEnum.getPg(sapUser.getEmployeeSubgroupId()));
				String category = fgCarCategory.compareTo(pgCarCategory)<=0?fgCarCategory:pgCarCategory;
				List<CompanyCarManagement> attachList = null;
				if(personalTitle.toLowerCase().indexOf("executive vice president")>-1) {	
					
				}else if("Vice President".equals(personalTitle)){
					
				}else if("FSE".equals(ContractTypeEnum.getName(sapUser.getEmployeeGroupId()))){
					if("7".equals(category)) {
						attachList = this.accordingChildNumber(carBrand, carCategory, "6", childrenNumber);	
					}else {
						attachList = this.accordingChildNumber(carBrand, carCategory, category, childrenNumber);			
					}
				}else {	
					if(!"7".equals(category)) {
						attachList = this.accordingChildNumber(carBrand, carCategory, category, childrenNumber);			
					}else {
						return new ArrayList<CompanyCarManagement>();
					}
				}
				if(attachList!=null && attachList.size()>0) {
					List<CompanyCarManagement> list = this.addAll(attachList, dynamicQuery(query));
					return list;
				}
			}
		}		
		List<CompanyCarManagement> list = dynamicQuery(query);
		return list;
	}
	
	/**
	 * Query the CompanyCarManagement
	 */
	public List<CompanyCarManagement> findByS_F_C_C_C(String staffCode,int childrenNumber,String carType,String carCategory,String carBrand,int start,int end) {
		try {
			SAPUser sapUser = SAPUserLocalServiceUtil.getSapUserByStaffCode(staffCode);
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(CompanyCarManagement.class);
			query = this.getCompanyCarCategoryQuery(query, sapUser, childrenNumber, carType, carCategory, carBrand);
			if(CompanyCarConstants.FIRST_COMPANY_CAR.equals(carType)) {
				if(sapUser!=null) {
					String personalTitle=sapUser.getPersonalTitle();
					String fgCarCategory = this.findCartegoryByC_G_G(carType, CompanyCarConstants.FUNCTION_GRADE, sapUser.getSg());
					String pgCarCategory = this.findCartegoryByC_G_G(carType, CompanyCarConstants.PERSONAL_GRADE, EmployeeSubGroupIDPersonalGradeEnum.getPg(sapUser.getEmployeeSubgroupId()));
					String category = fgCarCategory.compareTo(pgCarCategory)<=0?fgCarCategory:pgCarCategory;
					List<CompanyCarManagement> attachList = null;
					if(personalTitle.toLowerCase().indexOf("executive vice president")>-1) {		
					}else if("Vice President".equals(personalTitle)){
					}else if("FSE".equals(ContractTypeEnum.getName(sapUser.getEmployeeGroupId()))){
						if("7".equals(category)) {
							attachList = this.accordingChildNumber(carBrand, carCategory, "6", childrenNumber);	
						}else {
							attachList = this.accordingChildNumber(carBrand, carCategory, category, childrenNumber);			
						}
					}else {	
						if(!"7".equals(category)) {
							attachList = this.accordingChildNumber(carBrand, carCategory, category, childrenNumber);			
						}else {
							return new ArrayList<CompanyCarManagement>();
						}
					}
					if(attachList!=null && attachList.size()>0) {
						List<CompanyCarManagement> list = this.addAll(attachList, dynamicQuery(query));
						List<CompanyCarManagement> result = new ArrayList<CompanyCarManagement>();
						for(int i=start;i<end && i<list.size();i++) {
							result.add(list.get(i));
						}
						return result;
					}else {
						query.setLimit(start, end);
					}
				}
			}else {	
				query.setLimit(start, end);
			}
			List<CompanyCarManagement> list = dynamicQuery(query);
			return list;
		} catch (SystemException e) {
			return null;
		}
	}
	
	//Add the list1 and list2 to the list
	private List<CompanyCarManagement> addAll(List<CompanyCarManagement> list1,List<CompanyCarManagement> list2) {
		List<CompanyCarManagement> result = new ArrayList<CompanyCarManagement>();
		for(CompanyCarManagement carManagement:list1) {
			result.add(carManagement);
		}
		for(CompanyCarManagement carManagement:list2) {
			result.add(carManagement);
		}
		return result;
	}
	
	public List<CompanyCarManagement> findAll() throws SystemException {
		return companyCarManagementPersistence.findAll();
	}
	
	public List<CompanyCarManagement> findAll(int start,int end) throws SystemException {
		return companyCarManagementPersistence.findAll(start,end);
	}

	private DynamicQuery getCompanyCarCategoryQuery(DynamicQuery query,SAPUser sapUser,int childrenNumber,String carType,String carCategory,String carBrand) throws SystemException {
		if (Validator.isNotNull(carType)) {
			query.add(PropertyFactoryUtil.forName("carType").eq(carType));
		}
		if(CompanyCarConstants.FIRST_COMPANY_CAR.equals(carType)) {
			if(sapUser!=null) {
				String personalTitle=sapUser.getPersonalTitle();
				String fgCarCategory = this.findCartegoryByC_G_G(carType, CompanyCarConstants.FUNCTION_GRADE, sapUser.getSg());
				String pgCarCategory = this.findCartegoryByC_G_G(carType, CompanyCarConstants.PERSONAL_GRADE, EmployeeSubGroupIDPersonalGradeEnum.getPg(sapUser.getEmployeeSubgroupId()));
				String category = fgCarCategory.compareTo(pgCarCategory)<=0?fgCarCategory:pgCarCategory;
				String gradeType = fgCarCategory.compareTo(pgCarCategory)<=0?CompanyCarConstants.FUNCTION_GRADE:CompanyCarConstants.PERSONAL_GRADE;
				if(personalTitle.toLowerCase().indexOf("executive vice president")>-1) {
					query.add(RestrictionsFactoryUtil.ge("carCategory", "1"));					
					List<String> gradeTypes = new ArrayList<String>();
					gradeTypes.add(CompanyCarConstants.EVP);					
					gradeTypes.add(gradeType);					
					query.add(PropertyFactoryUtil.forName("gradeType").in(gradeTypes));
					List<String> grades = new ArrayList<String>();
					grades.add(CompanyCarConstants.ENTERPRISE_VICE_PRESIDENT);		
					grades.addAll(this.getGrades("2",true));					
					query.add(PropertyFactoryUtil.forName("grade").in(grades));						
					query.add(PropertyFactoryUtil.forName("contractType").eq("FSE"));			
				}else if("Vice President".equals(personalTitle)){
					query.add(RestrictionsFactoryUtil.ge("carCategory", "2"));
					
					List<String> gradeTypes = new ArrayList<String>();
					gradeTypes.add(CompanyCarConstants.VP);					
					gradeTypes.add(gradeType);					
					query.add(PropertyFactoryUtil.forName("gradeType").in(gradeTypes));						
					List<String> grades = new ArrayList<String>();
					grades.add(CompanyCarConstants.VICE_PRESIDENT);		
					grades.addAll(this.getGrades("3",true));							
					query.add(PropertyFactoryUtil.forName("grade").in(grades));						
					query.add(PropertyFactoryUtil.forName("contractType").eq("FSE"));
				}else if("FSE".equals(ContractTypeEnum.getName(sapUser.getEmployeeGroupId()))){
					query.add(PropertyFactoryUtil.forName("contractType").eq("FSE"));
					if("7".equals(category)) {
						query.add(PropertyFactoryUtil.forName("grade").eq(FunctionGradeEnum.FGL61.getIndex()));					
					}else {
						query.add(RestrictionsFactoryUtil.ge("carCategory", category));		
						query.add(PropertyFactoryUtil.forName("grade").in(this.getGrades(category,true)));					
					}
					
					query.add(PropertyFactoryUtil.forName("gradeType").eq(gradeType));	
				}else {
					query.add(RestrictionsFactoryUtil.ge("carCategory", category));		
					query.add(PropertyFactoryUtil.forName("grade").in(this.getGrades(category,true)));		
					query.add(PropertyFactoryUtil.forName("gradeType").eq(gradeType));					
					query.add(PropertyFactoryUtil.forName("contractType").eq("FSE"));			
				}
			}
		}else {
			if(sapUser!=null) {
				String personalTitle=sapUser.getPersonalTitle();
				String pgCarCategory = this.findCartegoryByC_G_G(carType, CompanyCarConstants.PERSONAL_GRADE, EmployeeSubGroupIDPersonalGradeEnum.getPg(sapUser.getEmployeeSubgroupId()));
				query.add(PropertyFactoryUtil.forName("contractType").eq("FSE"));				
				List<String> grades = new ArrayList<String>();
				if(personalTitle.toLowerCase().indexOf("executive vice president")>-1) {		
					query.add(RestrictionsFactoryUtil.ge("carCategory", "2"));		
					grades.add(CompanyCarConstants.ENTERPRISE_VICE_PRESIDENT);	
					grades.add(CompanyCarConstants.VICE_PRESIDENT);	
					grades.add(PersonalGradeEnum.PGL51.getIndex());									
				}else if("Vice President".equals(personalTitle)){
					query.add(RestrictionsFactoryUtil.ge("carCategory", "3"));	
					grades.add(CompanyCarConstants.VICE_PRESIDENT);	
					grades.add(PersonalGradeEnum.PGL51.getIndex());					
				}else {					
					if("3".equals(pgCarCategory)) {
						grades.add(PersonalGradeEnum.PGL31.getIndex());
						grades.add(PersonalGradeEnum.PGL51.getIndex());
					}else if("5".equals(pgCarCategory)) {
						grades.add(PersonalGradeEnum.PGL51.getIndex());						
					}else {
						grades.add(pgCarCategory);		
					}
				}			
				query.add(PropertyFactoryUtil.forName("grade").in(grades));	
			}
		}		
		if (Validator.isNotNull(carBrand)) {
			query.add(RestrictionsFactoryUtil.ilike("carBrand", "%" + carBrand + "%"));	
		}
		if (Validator.isNotNull(carCategory) && !"0".equals(carCategory)) {
			query.add(PropertyFactoryUtil.forName("carCategory").eq(carCategory));
		}
		query.addOrder(OrderFactoryUtil.asc("carCategory"));
		query.addOrder(OrderFactoryUtil.asc("carNo"));
		return query;
	}
	
	/**
	 * Query the CompanyCarManagement for paginition
	 */
	public List<CompanyCarManagement> findByC_C_C_C(String carType,String contractType,String carBrand,String carCategory,int start,int end)
		throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CompanyCarManagement.class);
		if (Validator.isNotNull(carType)) {
			query.add(RestrictionsFactoryUtil.eq("carType", carType));
		}
		if (Validator.isNotNull(contractType)) {
			query.add(PropertyFactoryUtil.forName("contractType").eq(contractType));
		}
		if (Validator.isNotNull(carBrand)) {
			query.add(RestrictionsFactoryUtil.ilike("carBrand", "%" + carBrand + "%"));		
		}
		if (Validator.isNotNull(carCategory)) {
			query.add(PropertyFactoryUtil.forName("carCategory").eq(carCategory));
		}
		query.setLimit(start, end);
		query.addOrder(OrderFactoryUtil.asc("carNo"));
		return dynamicQuery(query);
	}
	
	public CompanyCarManagement addCompanyCarManagement(
			CompanyCarManagement newCompanyCar, ServiceContext serviceContext)
		throws SystemException {

		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		long companyCarManagementId =
			counterLocalService.increment(CompanyCarManagement.class.getName());

		CompanyCarManagement companyCarManagement =
			companyCarManagementPersistence.create(companyCarManagementId);

		companyCarManagement.setCreateDate(serviceContext.getCreateDate(now));
		companyCarManagement.setModifiedDate(serviceContext.getModifiedDate(now));
		companyCarManagement.setCarType(newCompanyCar.getCarType());
		companyCarManagement.setContractType(newCompanyCar.getContractType());
		companyCarManagement.setGradeType(newCompanyCar.getGradeType());
		companyCarManagement.setGrade(newCompanyCar.getGrade());
		companyCarManagement.setCarBrand(newCompanyCar.getCarBrand());
		companyCarManagement.setCarModel(newCompanyCar.getCarModel());
		companyCarManagement.setCarCategory(newCompanyCar.getCarCategory());

		companyCarManagementPersistence.update(companyCarManagement);
		
		return companyCarManagement;
	}

	private List<String> getGrades(String category,boolean isFSE) {
		List<String> grades = new ArrayList<String>();
		List<Integer> levels = new ArrayList<Integer>();
		if(!isFSE) {
			levels.add(FunctionGradeEnum.FGL61.getLevel());
		}
		int cat = Integer.valueOf(category);
		for(FunctionGradeEnum f:FunctionGradeEnum.values()) {
			if(f.getLevel()>=cat && !levels.contains(f.getLevel())) {
				levels.add(f.getLevel());
				grades.add(f.getIndex());
			} 	
		}
		return grades;
	}
	
	private List<String> getGradesPG(String category,boolean isFSE) {
		List<String> grades = new ArrayList<String>();
		List<Integer> levels = new ArrayList<Integer>();
		if(!isFSE) {
			levels.add(FunctionGradeEnum.FGL61.getLevel());
		}
		int cat = Integer.valueOf(category);
		for(PersonalGradeEnum f:PersonalGradeEnum.values()) {
			if(f.getLevel()>=cat && !levels.contains(f.getLevel())) {
				levels.add(f.getLevel());
				grades.add(f.getIndex());
			}
		}
		return grades;
	}
	
	public CompanyCarManagement deleteCompanyCar(CompanyCarManagement companyCarManagement)
		throws SystemException {

		return super.deleteCompanyCarManagement(companyCarManagement);
	}

	public CompanyCarManagement deleteCompanyCar(long companyCarManagementId)
		throws SystemException, PortalException {

		CompanyCarManagement companyCarManagement =
			companyCarManagementLocalService.getCompanyCarManagement(
					companyCarManagementId);

		return deleteCompanyCar(companyCarManagement);
	}
	
	/**
	 * Generate the ticket no for the workflow
	 * for example:CC20150300000001
	 */
	public String generateTicketNo(String prefix) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String name = prefix + dateFormat.format(date);
		long number;
		try {
			number = counterLocalService.increment(name, 1);
			return name + String.format("%07d",number,1);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	/**
	 * 
	 * @param query
	 * @param carCategoryOfQueryCondition For the input text query condition 
	 * @param carCategory the level of the user.
	 * According the childNumber to the query condition
	 * @return query
	 * @throws SystemException 
	 */
	private List<CompanyCarManagement> accordingChildNumber(String carBrand,String carCategoryOfQueryCondition,String carCategory,int childrenNumber) throws SystemException {			
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CompanyCarManagement.class);
		query.add(PropertyFactoryUtil.forName("carType").eq(CompanyCarConstants.FIRST_COMPANY_CAR));
		if (Validator.isNotNull(carBrand)) {
			query.add(RestrictionsFactoryUtil.ilike("carBrand", "%" + carBrand + "%"));	
		}
		if (Validator.isNotNull(carCategoryOfQueryCondition) && !"0".equals(carCategoryOfQueryCondition)) {
			query.add(PropertyFactoryUtil.forName("carCategory").eq(carCategoryOfQueryCondition));
		}
		query.addOrder(OrderFactoryUtil.asc("carCategory"));
		query.addOrder(OrderFactoryUtil.asc("carNo"));
		/*if(childrenNumber==2) {
			List<String> carModels = new ArrayList<String>();
			carModels.add("Touran");
			carModels.add("Yeti");
			List<String> carCategorys = new ArrayList<String>();
			carCategorys.add("5");
			List<String> carBrands = new ArrayList<String>();
			carBrands.add("Volkswagen");
			carBrands.add("Skoda");
			query.add(PropertyFactoryUtil.forName("carModel").in(carModels));
			query.add(PropertyFactoryUtil.forName("carCategory").in(carCategorys));
			query.add(PropertyFactoryUtil.forName("carBrand").in(carBrands));		
			query.add(PropertyFactoryUtil.forName("contractType").eq("FSE"));
			query.add(PropertyFactoryUtil.forName("grade").eq(FunctionGradeEnum.FGL51.getIndex()));					
			List<CompanyCarManagement> list = dynamicQuery(query);
			return "6".equals(carCategory)?list:new ArrayList<CompanyCarManagement>();
		}else */
		/*if(childrenNumber==3) {
			List<String> carModels = new ArrayList<String>();
			carModels.add("Touran");
			carModels.add("Yeti");
			carModels.add("Sharan NF*");
			List<String> carCategorys = new ArrayList<String>();
			carCategorys.add("5");
			carCategorys.add("4");
			List<String> carBrands = new ArrayList<String>();
			carBrands.add("Volkswagen");
			carBrands.add("Skoda");
			query.add(PropertyFactoryUtil.forName("carModel").in(carModels));
			query.add(PropertyFactoryUtil.forName("carCategory").in(carCategorys));
			query.add(PropertyFactoryUtil.forName("carBrand").in(carBrands));	
			query.add(PropertyFactoryUtil.forName("contractType").eq("FSE"));	
			if("5".equals(carCategory)) {
				query.add(PropertyFactoryUtil.forName("grade").eq(FunctionGradeEnum.FGL41.getIndex()));		
				return dynamicQuery(query);
			}else if("6".equals(carCategory)) {
				List<String> grades = new ArrayList<String>();
				grades.add(FunctionGradeEnum.FGL41.getIndex());
				grades.add(FunctionGradeEnum.FGL51.getIndex());
				query.add(PropertyFactoryUtil.forName("grade").in(grades));		
				return dynamicQuery(query);
			}		
			return new ArrayList<CompanyCarManagement>();	
		}else if(childrenNumber>=4) {
			List<String> carModels = new ArrayList<String>();
			carModels.add("Touran");
			carModels.add("Yeti");
			carModels.add("Sharan NF*");
			carModels.add("T5 Topline*");
			List<String> carCategorys = new ArrayList<String>();
			carCategorys.add("5");
			carCategorys.add("4");
			List<String> carBrands = new ArrayList<String>();
			carBrands.add("Volkswagen");
			carBrands.add("Skoda");
			query.add(PropertyFactoryUtil.forName("carModel").in(carModels));
			query.add(PropertyFactoryUtil.forName("carCategory").in(carCategorys));
			query.add(PropertyFactoryUtil.forName("carBrand").in(carBrands));	
			query.add(PropertyFactoryUtil.forName("contractType").eq("FSE"));	
			if("5".equals(carCategory)) {
				query.add(PropertyFactoryUtil.forName("grade").eq(FunctionGradeEnum.FGL41.getIndex()));		
				return dynamicQuery(query);
			}else if("6".equals(carCategory)) {
				List<String> grades = new ArrayList<String>();
				grades.add(FunctionGradeEnum.FGL41.getIndex());
				grades.add(FunctionGradeEnum.FGL51.getIndex());
				query.add(PropertyFactoryUtil.forName("grade").in(grades));		
				return dynamicQuery(query);
			}		*/
		List<CompanyCarManagement> spicalCarList = new ArrayList<CompanyCarManagement>();
		List<CompanyCarManagement> spicalCarList1 = new ArrayList<CompanyCarManagement>();
		 if(childrenNumber>=3) {
				List<String> carModels = new ArrayList<String>();
				carModels.add("Sharan GP (without Navi)");
				List<String> carCategorys = new ArrayList<String>();
				carCategorys.add("5");
				carCategorys.add("4");
				List<String> carBrands = new ArrayList<String>();
				carBrands.add("Volkswagen");
				query.add(PropertyFactoryUtil.forName("carModel").in(carModels));
				query.add(PropertyFactoryUtil.forName("carCategory").in(carCategorys));
				query.add(PropertyFactoryUtil.forName("carBrand").in(carBrands));	
				query.add(PropertyFactoryUtil.forName("contractType").eq("FSE"));	
				if("5".equals(carCategory)) {
					query.add(PropertyFactoryUtil.forName("grade").eq(FunctionGradeEnum.FGL41.getIndex()));		
					spicalCarList = dynamicQuery(query);
				}else if("6".equals(carCategory)) {
					List<String> grades = new ArrayList<String>();
					grades.add(FunctionGradeEnum.FGL41.getIndex());
					grades.add(FunctionGradeEnum.FGL51.getIndex());
					query.add(PropertyFactoryUtil.forName("grade").in(grades));		
					spicalCarList = dynamicQuery(query);
				}
			
	  	   } 
	  		   
	  	if(childrenNumber>=4){
				CompanyCarManagement spcialcar = CompanyCarManagementLocalServiceUtil.createCompanyCarManagement(9999999);
				spcialcar.setCarModel("T6 Highline plus (without Navi)");
				spcialcar.setCarNo("9999");
				spcialcar.setCarCategory("*");
				spcialcar.setCarBrand("Volkswagen");
				spicalCarList1.add(spcialcar);
	  	   }
	  	spicalCarList1.addAll(spicalCarList);
		 return spicalCarList1;
	}
	
}