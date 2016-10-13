package com.otobon.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
 
public class AutomateImport {
	private static final String PATH = System.getProperty("user.dir")+File.separator+"data"+File.separator;
	public static void main1(String[] args) {
		System.out.println("hello hi wats tis..? ");
		  DBase db = new DBase();
	       	Properties dbProperties = new Properties();
			File dbPropsFile = new File(PATH+"dbfiles.properties");
			try {
		    if(dbPropsFile.exists()){
				FileInputStream input = new FileInputStream(dbPropsFile);
				dbProperties.load(input); 	
				input.close();
				input=null;
				String host = dbProperties.getProperty("host");
				String user = dbProperties.getProperty("user");
				String password = dbProperties.getProperty("password");
				String schema = dbProperties.getProperty("schema");
				String port = dbProperties.getProperty("port");
				String fileSep = dbProperties.getProperty("fileSep");
				Connection conn = db.connect("jdbc:mysql://"+host+":"+port+"/"+schema,user,password);
				for(int i = 1; i < 30; i++) {
					if(i==28 || i==29 || i==5  || i==15 || i==6)
//					if(i!=15)
						continue;
					if(dbProperties.containsKey(Integer.toString(i))){
					String name = dbProperties.getProperty(Integer.toString(i));
					System.out.println("name="+name);
					if(name!=null){
						db.deleteData(conn, name, "");
					}
					}
				}
		    }
		    }catch (Exception e) {
				// TODO: handle exception
		    	e.printStackTrace();
			}
		    
		    }
	public static void main(String[] args) {
		System.out.println("hello hi wats tis..? ");
		  DBase db = new DBase();
	       	Properties dbProperties = new Properties();
			File dbPropsFile = new File(PATH+"dbfiles.properties");
			try {
		    if(dbPropsFile.exists()){
				FileInputStream input = new FileInputStream(dbPropsFile);
				dbProperties.load(input); 	
				input.close();
				input=null;
				String path = dbProperties.getProperty("alldir");
				String host = dbProperties.getProperty("host");
				String user = dbProperties.getProperty("user");
				String password = dbProperties.getProperty("password");
				String schema = dbProperties.getProperty("schema");
				String port = dbProperties.getProperty("port");
				String fileSep = dbProperties.getProperty("fileSep");
				Connection conn = db.connect("jdbc:mysql://"+host+":"+port+"/"+schema,user,password);
				int stYear= Integer.parseInt(dbProperties.getProperty("startYear"));
				int endYear= Integer.parseInt(dbProperties.getProperty("endYear"));
//				for(int i = 1; i < 12; i++) {
//					if(i==5 || i==6)
//						continue;
//					if(dbProperties.containsKey(Integer.toString(i))){
//					  String name = dbProperties.getProperty(Integer.toString(i));
//					  System.out.println("name="+name);
////					  String fileName =path+"nvd_v2_"+year+fileSep+name+".txt";
//					  String fileName =path+name+".txt";
//						if(name.equalsIgnoreCase("Subdivisions")){
//							String fields="ModelYear,DivisionID,SubdivisionID,HistSubdivisionID,SubdivisionName";
//							db.importData(conn,name.toLowerCase(),fileName,fields,true);
//						}else if(name.equalsIgnoreCase("Manufacturers")){
//							String fields="ManufacturerID,ManufacturerName";
//							db.importData(conn,name.toLowerCase(),fileName,fields,true);
//						}else if(name.equalsIgnoreCase("MktClass")){
//							String fields="MktClassID,MarketClass";
//							db.importData(conn,name.toLowerCase(),fileName,fields,true);
//						}else if(name.equalsIgnoreCase("Divisions")){
//							String fields="DivisionID,ManufacturerID,DivisionName";
//							db.importData(conn,name.toLowerCase(),fileName,fields,true);
//						}else if(name.equalsIgnoreCase("CategoryHeaders")){
//							String fields="CategoryHeaderID,CategoryHeader,Sequence";
//							db.importData(conn,name.toLowerCase(),fileName,fields,true);
//						}
////						else if(name.equalsIgnoreCase("ChromeReviews")){
////							String fields="CategoryHeaderID,CategoryHeader,Sequence";
////							db.importData(conn,name.toLowerCase(),fileName,fields,true);
////						}
//						else if(name.equalsIgnoreCase("NormCILabels")){
//							String fields="LabelID,Label,TypeID,LabelSequence";
//							db.importData(conn,name.toLowerCase(),fileName,fields,true);
//						}else if(name.equalsIgnoreCase("StdHeaders")){
//							String fields="HeaderID,Header";
//							db.importData(conn,name.toLowerCase(),fileName,fields,true);
//						}else if(name.equalsIgnoreCase("TechTitleHeader")){
//							String fields="TechTitleHeaderID,TechTitleHeaderText,Sequence";
//							db.importData(conn,name.toLowerCase(),fileName,fields,true);
//						}else if(name.equalsIgnoreCase("CITypes")){
//							String fields="TypeID,Type";
//							db.importData(conn,name.toLowerCase(),fileName,fields,true);
//						}
//					}
//				}
				for(int year=endYear;year>=stYear;year--){
					System.out.println("YEAR :: "+year);
				for(int i = 1; i < 30; i++) {
					if(i==28 || i==29 || i==5  || i==15 || i==6)
//					if(i!=15)
						continue;
					if(dbProperties.containsKey(Integer.toString(i))){
					String name = dbProperties.getProperty(Integer.toString(i));
					System.out.println("name="+name);
					if(name!=null){
//					String fileName =path+"nvd_v2_"+year+fileSep+name+".txt";
					String fileName =path+year+fileSep+name+".txt";
//					String fileName =path+name+".txt";
					System.out.println("File name="+fileName);
					if(name.equalsIgnoreCase("Subdivisions")){
						String fields="ModelYear,DivisionID,SubdivisionID,HistSubdivisionID,SubdivisionName";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("Manufacturers")){
						String fields="ManufacturerID,ManufacturerName";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("MktClass")){
						String fields="MktClassID,MarketClass";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("Divisions")){
						String fields="DivisionID,ManufacturerID,DivisionName";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("CategoryHeaders")){
						String fields="CategoryHeaderID,CategoryHeader,Sequence";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}
//					else if(name.equalsIgnoreCase("ChromeReviews")){
//						String fields="CategoryHeaderID,CategoryHeader,Sequence";
//						db.importData(conn,name.toLowerCase(),fileName,fields,true);
//					}
					else if(name.equalsIgnoreCase("NormCILabels")){
						String fields="LabelID,Label,TypeID,LabelSequence";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("StdHeaders")){
						String fields="HeaderID,Header";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("TechTitleHeader")){
						String fields="TechTitleHeaderID,TechTitleHeaderText,Sequence";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("CITypes")){
						String fields="TypeID,Type";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("Colors")){
						String fields="StyleID,Ext1Code,Ext2Code,IntCode,Ext1ManCode,Ext2ManCode,IntManCode,OrderCode,AsTwoTone,Ext1Desc,Ext2Desc,IntDesc,ColorsCondition,GenericExtColor,GenericExt2Color,Ext1RGBHex,Ext2RGBHex,Ext1MfrFullCode,Ext2MfrFullCode";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					} else if(name.equalsIgnoreCase("StyleCats")){
						String fields="StyleID,CategoryID,FeatureType,Sequence,State";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					} else if(name.equalsIgnoreCase("Styles")){
						String fields="StyleID,HistStyleID,ModelID,ModelYear,Sequence,StyleCode,FullStyleCode,StyleName,TrueBasePrice,Invoice,MSRP,Destination,StyleCVCList,MktClassID,StyleNameWOTrim,Trim,PassengerCapacity,PassengerDoors,ManualTrans,AutoTrans,FrontWD,RearWD,AllWD,FourWD,StepSide,Caption,AutoBuilderStyleID,PriceState,CFModelName,CFStyleName,CFDriveTrain,CFBodyType";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
//						break;
					} else if(name.equalsIgnoreCase("BodyStyles")){
						String fields="StyleID,bodystyle,isprimary";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("JPGs")){
						String fields="StyleID,JPGName,SubdivisionName,ModelName,StyleName,Year";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("Models")){
						System.out.println("Hell O in models :: "+name);
						String fields="ModelID,HistModelID,ModelYear,DivisionID,SubdivisionID,ModelName,@date,ModelComment";
						db.importData1(conn,name.toLowerCase(),fileName,fields,true);
//						break;
					} else if(name.equalsIgnoreCase("NormConsInfo")){
						String fields="StyleID,LabelID,Value,Qualifier,QualifierSequence,NormGroup";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("Prices")){
						String fields="StyleID,Sequence,OptionCode,PriceRuleDesc,PricesCondition,Invoice,MSRP,PriceState";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("TechTitles")){
						String fields="TitleID,Sequence,Title,TechTitleHeaderID";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("TechSpecs")){
						String fields="StyleID,TitleID,Sequence,Text,techspecscondition";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("ConsInfo")){
						String fields="StyleID,TypeID,Text";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("Categories")){
						String fields="CategoryID,Category,CategoryTypeFilter,CategoryHeaderID,UserFriendlyName";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}else if(name.equalsIgnoreCase("Standards")){
						String fields="StyleID,HeaderID,Sequence,Standard,CategoryList";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}
					else if(name.equalsIgnoreCase("Options")){
						String fields="StyleID,HeaderID,Sequence,OptionCode,OptionDesc,OptionKindID,CategoryList,PON,ExtDescription,SupportedLogic,UnsupportedLogic,PriceNotes";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}
					else if(name.equalsIgnoreCase("OptHeaders")){
						String fields="HeaderID,Header";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}
					else if(name.equalsIgnoreCase("OptKinds")){
						String fields="OptionKindID,OptionKind";
						db.importData(conn,name.toLowerCase(),fileName,fields,true);
					}
					else if(name.equalsIgnoreCase("ZipToStyles")){
						if(year>2000){
						String fields="StyleID,HistStyleID,AutoBuilderStyleID,FilterRule,ZipCodes";
							db.importData(conn,name.toLowerCase(),fileName,fields,true);
						}
					} else {
						
						db.importData(conn,name.toLowerCase(),fileName);
					}
					}
					}
				}
				}
						    } 
	    } catch (FileNotFoundException fe) {
		} catch (IOException ie) {
			ie.printStackTrace();
		}
 
}
}
	class DBase {
		public DBase(){
		}
 
    public Connection connect(String db_connect_str,String db_userid, String db_password){
    	System.out.println("Hello in DB connection");
        Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(db_connect_str,db_userid, db_password);
            System.out.println("Hello DB connected");
        } catch(Exception e) {
            e.printStackTrace();
            conn = null;
        }
        return conn;    
    }
    
    private final String PATH = System.getProperty("user.dir")+File.separator+"otobon"+File.separator+"data"+File.separator+"VINDATA";
    
    private void im(){
    	Properties hibernateProperties = new Properties();
		File dbPropsFile = new File(PATH+"dbtables.properties");
		try {
	    if(dbPropsFile.exists()){
			FileInputStream input = new FileInputStream(dbPropsFile);
			hibernateProperties.load(input); 	
			input.close();
			input=null;
			 System.out.println("b4 setting props");
		}
		} catch (FileNotFoundException fe) {
		} catch (IOException ie) {
			ie.printStackTrace();
		}
    }
    
    public void importData(Connection conn,String tableName,String filename,String fields,boolean ignoreHeader) {
        Statement stmt;
        String query;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            if(ignoreHeader){
//            	query = "LOAD DATA INFILE '"+filename+"' INTO TABLE "+tableName+" FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '~' LINES TERMINATED BY '\r\n' IGNORE 1 LINES ("+fields+") SET EffectiveDate = date_format(str_to_date(@date, '%d-%M-%Y'), '%m/%d/%Y');";
//            	query = "LOAD DATA LOCAL INFILE '"+filename+"' INTO TABLE "+tableName+" FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '~' LINES TERMINATED BY '\r\n' IGNORE 1 LINES ("+fields+") SET EffectiveDate = str_to_date(@date, '%m/%d/%Y');";
            	query = "LOAD DATA LOCAL INFILE '"+filename+"' INTO TABLE "+tableName+" FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '~' LINES TERMINATED BY '\r\n' IGNORE 1 LINES ("+fields+") ;";
            	System.out.println(query);
            } else {
            	query = "LOAD DATA INFILE '"+filename+"' INTO TABLE "+tableName+" FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '~' LINES TERMINATED BY '\r\n' ("+fields+");";
            }
            stmt.executeUpdate(query);
        } catch(Exception e) {
            e.printStackTrace();
            stmt = null;
        }
    }

    public void importData1(Connection conn,String tableName,String filename,String fields,boolean ignoreHeader) {
    	Statement stmt;
    	String query;
    	try {
    		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    		if(ignoreHeader){
//            	query = "LOAD DATA INFILE '"+filename+"' INTO TABLE "+tableName+" FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '~' LINES TERMINATED BY '\r\n' IGNORE 1 LINES ("+fields+") ;";
//    			query = "LOAD DATA INFILE '"+filename+"' INTO TABLE "+tableName+" FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '~' LINES TERMINATED BY '\r\n' IGNORE 1 LINES ("+fields+") SET EffectiveDate = str_to_date(@date, '%m/%d/%Y');";
            	query = "LOAD DATA LOCAL INFILE '"+filename+"' INTO TABLE "+tableName+" FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '~' LINES TERMINATED BY '\r\n' IGNORE 1 LINES ("+fields+") SET EffectiveDate = str_to_date(@date, '%m/%d/%Y');";
            	System.out.println(query);
    		} else {
    			query = "LOAD DATA INFILE '"+filename+"' INTO TABLE "+tableName+" FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '~' LINES TERMINATED BY '\r\n' ("+fields+");";
    		}
    		stmt.executeUpdate(query);
    	} catch(Exception e) {
    		e.printStackTrace();
    		stmt = null;
    	}
    }
    
    public void importData(Connection conn,String tableName,String filename) {
        Statement stmt;
        String query;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            query = "LOAD DATA INFILE '"+filename+"' INTO TABLE "+tableName+" FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '~' LINES TERMINATED BY '\r\n' IGNORE 1 LINES;";
            stmt.executeUpdate(query);
        } catch(Exception e) {
            e.printStackTrace();
            stmt = null;
        }
    }

    public void deleteData(Connection conn,String tableName,String filename) {
    	Statement stmt;
    	String query;
    	try {
    		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    		query = "DELETE FROM "+tableName;
    		stmt.executeUpdate(query);
    	} catch(Exception e) {
    		e.printStackTrace();
    		stmt = null;
    	}
    }
}
