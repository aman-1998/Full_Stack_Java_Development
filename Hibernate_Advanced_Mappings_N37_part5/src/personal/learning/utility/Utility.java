package personal.learning.utility;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Utility<T> {
	
	/**
	 * Method used to query in the database using native SQL
	 * 
	 * @param session
	 * @param sql
	 * @param view
	 * @return outputViewList
	 */
	public List<T> query(Session session, String sql, T view) {
		Query query = session.createNativeQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();
		List<T> outputViewList = populateSummaryView(data, view);
		return outputViewList;
	}
	
	/**
	 * Populate List of summaryView
	 * 
	 * @param data : List
	 * @param view : SummaryView
	 * @return outputViewList
	 */
	public List<T> populateSummaryView(List data, T view) {
		List<T> outputViewList = new ArrayList<T>();
		for(Object object : data) {
			T newView = ObjectUtils.clone(view);
            Map row = (Map)object;
            Set<String> keySet = row.keySet();
            String keyFinal = null;
            for(String key : keySet) {
            	keyFinal = key.replaceAll("_", "");
            	for (Field f : newView.getClass().getDeclaredFields()) {
					if(StringUtils.equalsIgnoreCase(keyFinal, f.getName())) {
						try {
							f.set(newView, row.get(key));
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
				}
            }
            outputViewList.add(newView);
        }
		return outputViewList;
	}
	
}
