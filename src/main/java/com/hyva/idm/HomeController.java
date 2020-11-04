package com.hyva.idm;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyva.idm.pkt.pktBeans.PktFieldsBean;
import com.hyva.idm.pkt.pktService.PktService;
import com.hyva.idm.sass.sassendpoints.HiConnectEndPoint;
import com.hyva.idm.sass.sassentities.PermissionGroup;
import com.hyva.idm.sass.sassentities.PermissionMaster;
import com.hyva.idm.sass.sasspojo.PermissionMasterDTO;
import com.hyva.idm.sass.sasspojo.PktFieldsPojo;
import com.hyva.idm.sass.sassrespositories.SassPermissionGroupRepository;
import com.hyva.idm.sass.sassrespositories.SassPermissionMasterRepository;
import com.hyva.idm.sass.sassrespositories.SassPktfieldsRepository;
import com.hyva.idm.sass.sassservice.BasicDataService;
import com.hyva.idm.sass.sassservice.SassControlPanelService;
import com.hyva.idm.sass.sassservice.SassPermissionMasterService;
import com.hyva.idm.service.ResourceHandler;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.InputStream;
import java.util.Iterator;

@Controller
public class HomeController {

	@Autowired
	SassPermissionMasterService sassPermissionMasterService;
	@Autowired
	SassPermissionMasterRepository sassPermissionMasterRepository;
	@Autowired
	SassPermissionGroupRepository sassPermissionGroupRepository;
	@Autowired
	BasicDataService basicDataService;
	@Autowired
	HiConnectEndPoint hiConnectEndPoint;
	@Autowired
	SassPktfieldsRepository sassPktfieldsRepository;
	@Autowired
    SassControlPanelService sassControlPanelService;
	@Autowired
	PktService pktService;


	@RequestMapping(value = "/pos/v3/updateorder", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateorder(@Validated @RequestBody String jsonString) throws Exception {
		hiConnectEndPoint.getZomatoData(jsonString,"Zomato",null);
		return  ResponseEntity.status(200).body("");
	}

	@RequestMapping(value = "/getPendingNotificationsByRestaurantId",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity getPendingNotificationsByRestau5rantId(@RequestBody String restaurantId){
	    return ResponseEntity.status(200).body(hiConnectEndPoint.getPendingNotificationsByRestaurantId(restaurantId));
    }
    @RequestMapping(value = "/getAllNotifications",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity getAllNotifications(@RequestBody String json)throws Exception{
	    return ResponseEntity.status(200).body(hiConnectEndPoint.getAllNotifications(json));
    }

	@RequestMapping("/home")
	public String home(@CookieValue(value = "accessToken", required = false) String accessToken, Model model) throws Exception {

//		boolean b = licenseService.checkForLicense();
		boolean b = true;
		if (b) {
				Long masterPermissionGroupList = sassPermissionGroupRepository.count();
                if (masterPermissionGroupList <= 0) {
					HSSFSheet sheet = getXlsSheet("static/importSheet/Permission_Group.xls");
					HSSFRow hssfRow;
					Iterator iterable = sheet.rowIterator();
					while (iterable.hasNext()) {
						PermissionGroup groupObj = new PermissionGroup();
						hssfRow = (HSSFRow) iterable.next();
						String description = hssfRow.getCell(0).toString();
						String featureName = hssfRow.getCell(1).toString();
						String pgKey = hssfRow.getCell(2).toString();
						String saasStatus = hssfRow.getCell(3).toString();
						PermissionGroup permissionGroup = new PermissionGroup();
						permissionGroup.setDescription(description);
						permissionGroup.setFeatureName(featureName);
						permissionGroup.setPgkey(pgKey);
						permissionGroup.setSaasStatus(saasStatus);
						sassPermissionGroupRepository.save(permissionGroup);
					}
				}
			        Long masterPermissionMasterList = sassPermissionMasterRepository.count();
                if(masterPermissionMasterList <=0){
			        HSSFSheet sheet = getXlsSheet("static/importSheet/HiNextLevels.xls");
                    HSSFRow hssfRow;
                    Iterator iterable = sheet.rowIterator();
                    while (iterable.hasNext()) {
                        hssfRow = (HSSFRow) iterable.next();
                        Cell accountgroup = hssfRow.getCell(0);
                        Cell level1 = hssfRow.getCell(1);
                        Cell level2 = hssfRow.getCell(2);
                        Cell description = hssfRow.getCell(3);
                        Cell status = hssfRow.getCell(4);
                        Cell permissionkey = hssfRow.getCell(5);
                        PermissionMasterDTO permissionMasterDTO = new PermissionMasterDTO();
                        if (accountgroup != null) {
							PermissionGroup permissionGroup = sassPermissionMasterService.getpermissionMasterGroupMaster(accountgroup.toString());
                            if (permissionGroup != null) {
                                permissionMasterDTO.setPgId(permissionGroup.getPgId());
                            }
                            PermissionMaster permissionMaster = null;
                            if (level1 != null) {
                             permissionMaster = sassPermissionMasterService.getpermissionMasterMaster(level1.toString());
                                if (permissionMaster != null) {
                                    permissionMasterDTO.setPmId(Long.parseLong(permissionMaster.getPmId().toString()));
                                } else {
                                    permissionMasterDTO.setPmId(null);
                                }
                            } else {
                                permissionMasterDTO.setPmId(null);
                            }
                            if (level2 != null) {
                                permissionMaster = sassPermissionMasterService.getpermissionMasterMaster(level2.toString());
                                if (permissionMaster != null) {
                                    permissionMasterDTO.setPmId(Long.parseLong(permissionMaster.getPmId().toString()));
                                } else {
                                    permissionMasterDTO.setPmId(null);
                                }
                            } else {
                                permissionMasterDTO.setPmId(null);
                            }
                            permissionMasterDTO.setDescription(description.toString());
                            permissionMasterDTO.setSaasStatus(status.toString());
                            permissionMasterDTO.setPermissionMasterkey(permissionkey.toString());
							sassPermissionMasterService.NewpermissionMaster(permissionMasterDTO);
                        }
                    }
                }

			Long ssassPktfieldsRepository = sassPktfieldsRepository.count();
                if(ssassPktfieldsRepository<=0){
                    HSSFSheet sheet = getXlsSheet("static/importSheet/Pktfields.xls");
                    HSSFRow hssfRow;
                    Iterator iterable = sheet.rowIterator();
                    while (iterable.hasNext()){
                        hssfRow= (HSSFRow)iterable.next();
                        Cell tableName=hssfRow.getCell(0);
                        Cell fieldName=hssfRow.getCell(1);
                        Cell GroupOf=hssfRow.getCell(2);
                        Cell status=hssfRow.getCell(3);
                        PktFieldsBean pktFieldsPojo  = new PktFieldsBean();
                        pktFieldsPojo.setTableName(tableName == null ? null : tableName.toString());
                        pktFieldsPojo.setFieldName(fieldName == null ? null : fieldName.toString());
                        pktFieldsPojo.setGroupOf(GroupOf == null ? null : GroupOf.toString());
                        pktFieldsPojo.setStatus(status == null ? null : status.toString());
					pktService.SavePktFields(pktFieldsPojo);

                    }
				}

//			if (StringUtils.isBlank(accessToken))

			if (accessToken!=null) {
				model.addAttribute("pageName", "login");
			}

//
//			else {
//				Map<String, String> credentialsMap = hiposService.validateToken(accessToken);
//				if (credentialsMap != null) {
//					String dbKeyword = credentialsMap.get(HiNextConstants.DATABASE);
//					TenantContext.setCurrentTenant(dbKeyword);
//					SubscritptionDetails subscritptionDetails = companyInfoService.getSubscritptionDetails();
//					Company company = companyInfoService.getCompany();
//					AccountSetup accountSetup = companyInfoService.getAccountSetup();
//					if (!(subscritptionDetails != null && !StringUtils.isBlank(subscritptionDetails.getStatus()))) {
//						model.addAttribute("pageName", "subscription");
//					} else if (company == null) {
//						model.addAttribute("pageName", "setup");
//					} else if (accountSetup.getUnitPrice() == null) {
//						model.addAttribute("pageName", "configuration");
//					}
//				}
//			}
//			CompanyInfo companyInfo = companyInfoService.getCompanyInfo();
//			if (companyInfo == null) {
//				model.addAttribute("pageName", "license");
//			}
//		}
//

			else {
				model.addAttribute("pageName", "OrderList");
			}
			basicDataService.insertBasicData();
		}

		return "index";
	}

	public HSSFSheet getXlsSheet(String fileName) throws Exception {
		ResourceHandler resourceLoader = new ResourceHandler();
		InputStream inputStream = resourceLoader.getResourceAsStream(fileName);
		InputStream exelFileReader = inputStream;
		HSSFWorkbook workbook = new HSSFWorkbook(exelFileReader);
		HSSFSheet sheet = workbook.getSheetAt(0);
		return sheet;
	}
}
