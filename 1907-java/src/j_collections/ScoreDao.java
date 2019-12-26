package j_collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ScoreDao {
	Map<String, List<ScoreVo>> map;
	List<ScoreVo> lss;
	
	
	public ScoreDao() {
	}
	
	public ScoreDao(Map<String, List<ScoreVo>> map) {
		this.map=map;
	}
	
	public boolean insert(ScoreVo vo) {
		boolean b = true;
		try {
			String key = vo.getSno();
			if(map.containsKey(key)) {
				List<ScoreVo> list = map.get(key);
				list.add(vo);
			}else {// 키가 없는 경우
				List<ScoreVo> list = new ArrayList<ScoreVo>();
				list.add(vo);
				map.put(key, list);
			}
		}catch (Exception e) {
			b=false;
		}
		return b;
	}
	
	public boolean update(String key, int index, ScoreVo vo) {
		boolean b = true;
		try {
			List<ScoreVo> list = map.get(key);
			list.set(index, vo);
		} catch (Exception e) {
			b = false;
		}
		
		return true;
	}
	
	public boolean delete(String key, int index) {
		boolean b = true;
		
		try {
			List<ScoreVo> list = map.get(key);
			list.remove(index);
		} catch (Exception e) {
			b=false;
		}
		
		return b;
	}
	
	public Map<String, List<ScoreVo>> list(String findstr){
		Map<String, List<ScoreVo>> newMap = new HashMap<String, List<ScoreVo>>();
		
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			if(key.indexOf(findstr)>=0) {
				newMap.put(key, map.get(key));
			}
		}
		
		return newMap;
	}
}
