package de.guskoeln;

import java.util.HashMap;
import java.util.Map;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

@Controller("/formatfunc")
public class FormatFuncController {

	private static Map<String, Integer> formatFuncMap = new HashMap<>();
	
	@Get("/{format}")
	public int index(@PathVariable String format) {
		int seq = readSeqForFormat(format);
		seq++;
		saveSeqForFormat(format, seq);
		return seq;
	}
	
	private void saveSeqForFormat(String format, int seq) {
		formatFuncMap.put(format, seq);
	}

	private int readSeqForFormat(String format) {
		int seq = 0;
		if(formatFuncMap.containsKey(format)) {
			seq = formatFuncMap.get(format);
		}
		
		return seq;
	}
}
