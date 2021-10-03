package buyHistory.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class BuyHistoryUtil {
	
	public static String getUUIDorderNo() {
		
		java.util.Date now = new java.util.Date();
	    SimpleDateFormat vans = new SimpleDateFormat("yyyyMMdd");
	    String wDate = vans.format(now);
		
		String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 7);
		
		return wDate+uuid;
		
	}

}
