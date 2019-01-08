
package com.doublechaintech.search.catalog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.search.BaseRowMapper;
import com.doublechaintech.search.site.Site;

public class CatalogMapper extends BaseRowMapper<Catalog>{
	
	protected Catalog internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Catalog catalog = getCatalog();		
		 		
 		setId(catalog, rs, rowNumber); 		
 		setDisplayName(catalog, rs, rowNumber); 		
 		setSellerId(catalog, rs, rowNumber); 		
 		setSite(catalog, rs, rowNumber); 		
 		setVersion(catalog, rs, rowNumber);

		return catalog;
	}
	
	protected Catalog getCatalog(){
		return new Catalog();
	}		
		
	protected void setId(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(CatalogTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		catalog.setId(id);
	}
		
	protected void setDisplayName(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String displayName = rs.getString(CatalogTable.COLUMN_DISPLAY_NAME);
		if(displayName == null){
			//do nothing when nothing found in database
			return;
		}
		
		catalog.setDisplayName(displayName);
	}
		
	protected void setSellerId(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String sellerId = rs.getString(CatalogTable.COLUMN_SELLER_ID);
		if(sellerId == null){
			//do nothing when nothing found in database
			return;
		}
		
		catalog.setSellerId(sellerId);
	}
		 		
 	protected void setSite(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
 		String siteId = rs.getString(CatalogTable.COLUMN_SITE);
 		if( siteId == null){
 			return;
 		}
 		if( siteId.isEmpty()){
 			return;
 		}
 		Site site = catalog.getSite();
 		if( site != null ){
 			//if the root object 'catalog' already have the property, just set the id for it;
 			site.setId(siteId);
 			
 			return;
 		}
 		catalog.setSite(createEmptySite(siteId));
 	}
 	
	protected void setVersion(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(CatalogTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		catalog.setVersion(version);
	}
		
		

 	protected Site  createEmptySite(String siteId){
 		Site site = new Site();
 		site.setId(siteId);
 		site.setVersion(Integer.MAX_VALUE);
 		return site;
 	}
 	
}


