package com.example

import groovy.io.FileType

/**
 * Created by liza.ivanova on 2/23/18.
 */
class TestUtil {

    static List<File> getJobFiles() {
        List<File> files = []
        new File('src/jobs').eachFileRecurse(FileType.FILES) {
            if (it.name.endsWith('.groovy')) {
                files << it
            }
        }
        files
    }

    /**
     * Write a single XML file, creating any nested dirs.
     */
    static void writeFile(File dir, String name, String xml) {
        List tokens = name.split('/')
        File folderDir = tokens[0..<-1].inject(dir) { File tokenDir, String token ->
            new File(tokenDir, token)
        }
        folderDir.mkdirs()

        File xmlFile = new File(folderDir, "${tokens[-1]}.xml")
        xmlFile.text = xml
    }
}
