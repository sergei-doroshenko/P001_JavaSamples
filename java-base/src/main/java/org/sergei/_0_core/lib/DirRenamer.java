package org.sergei._0_core.lib;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 24.05.2015.
 */
public class DirRenamer {
    public static final String src = "E:\\Projects\\IdeaProjects\\goCourses\\1Z0-804\\src";

    public static void main(String[] args) {
        List<File> dirs = getDirList(src);
        dirs.forEach(System.out::println);
//        dirs.forEach(dir -> System.out.println(dir.getAbsolutePath()));
//        rename(dirs);

//        dirs.forEach(dir -> rename(getDirList(dir.getAbsolutePath())));
//        String res = "Listing 3.5".replaceAll("[\\s.]", "_");
//        System.out.println(res);
    }

    private static List<File> getDirList(String path) {
        File dir = new File(path);
        String[] files = dir.list();
        List<File> result = new ArrayList<>();
        for (String name : files) {
            result.add(new File(path + "\\" + name));
        }
        return result;
    }

    private static void rename(List<File> list) {
        list
                .stream()
                .filter(dir -> dir.getName().matches("^Listing[\\s.\\d]*"))
                .map(d -> d.renameTo(new File(d.getAbsolutePath().replaceAll("[\\s.]", "_"))));

    }
}
