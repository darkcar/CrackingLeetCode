package leetcode.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FileSystem {
	// Define the data structure
	class Dir {
		// Dirs: the directories of in the current directory 
		// Files: the files in current directory 
		HashMap<String, Dir> dirs = new HashMap<>();
		HashMap<String, String> files = new HashMap<>();
	}
	private Dir root; 
	
	public FileSystem() {
		this.root = new Dir();
	}
	
	public List<String> ls(String path) {
		Dir t = root; 
		List<String> res = new ArrayList<String>();
		// Not root directory
		if (!path.equals("/")) {
			String[] names = path.split("/");
			for (int i = 1; i < names.length - 1; i ++) {
				t = t.dirs.get(names[i]);
			}
			
			if (t.files.containsKey(names[names.length - 1])) {
				res.add(names[names.length - 1]);
				return res;
			} else {
				t = t.dirs.get(names[names.length - 1]);
			}
		}
		res.addAll(new ArrayList<String>(t.dirs.keySet()));
		res.addAll(new ArrayList<String>(t.files.keySet()));
		Collections.sort(res);
		return res;
	}
	
	public void mkdir(String path) {
		Dir t = root; 
		String[] names = path.split("/");
		for (int i = 1; i < names.length; i ++) {
			if (!t.dirs.containsKey(names[i])) {
				t.dirs.put(names[i], new Dir());
			}
			t = t.dirs.get(names[i]);
		}
	}
	
	public void addContentToFile(String filePath, String content) {
		Dir t = root; 
		String[] names = filePath.split("/");
		for (int i = 1; i < names.length - 1; i ++) {
			t = t.dirs.get(names[i]);
		}
		t.files.put(names[names.length - 1], t.files.getOrDefault(names[names.length - 1], "") + content);
	}
	
	public String readContentFromFile(String filePath) {
		Dir t = root;
		String[] names = filePath.split("/");
		for (int i = 1; i < names.length - 1; i ++) {
			t = t.dirs.get(names[i]);
		}
		return t.files.get(names[names.length - 1]);
	}
}
