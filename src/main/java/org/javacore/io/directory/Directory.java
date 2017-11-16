package org.javacore.io.directory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Jeff Lee
 * @since 2015-7-13 09:17:11
 * 目录实用工具
 */
public final class Directory {

    /**
     * 返回过滤后的文件列表
     * @param dir 目录
     * @param regex 正则表达式
     * @return
     */
	public static File[] local(File dir,final String regex){
		return dir.listFiles(new FilenameFilter() { // 文件过滤接口
			private Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}

	public static File[] local(String path, final String regex){
		return local(new File(path),regex);
	}

	public static class TreeInfo implements Iterable<File>{
		public List<File> files = new ArrayList<>();
		public List<File> dirs = new ArrayList<>();

		@Override
		public Iterator<File> iterator() {
			return files.iterator();
		}

		public void addAll(TreeInfo other) {
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}

		@Override
		public String toString() {
			return "dirs: " + dirs +
					"\n\nfiles: " + files;
		}
	}

	public static TreeInfo walk(String start,String regex) {
		return recuresDirs(new File(start),regex);
	}

	public static TreeInfo walk(File start,String regex) {
		return recuresDirs(start, regex);
	}

	public static TreeInfo walk(File start) {
		return recuresDirs(start, ".*");// 全部
	}

	public static TreeInfo walk(String start) {
		return recuresDirs(new File(start), ".*");// 全部
	}

	public static TreeInfo recuresDirs(File startDir,String regex) {
		TreeInfo result = new TreeInfo();
		for(File item : startDir.listFiles()) {
			if (item.isDirectory()) {
				result.dirs.add(item);
				result.addAll(recuresDirs(item, regex));
			} else
				if (item.getName().matches(regex))
					result.files.add(item);
		}
		return result;
	}

}
