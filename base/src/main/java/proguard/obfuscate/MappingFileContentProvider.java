package proguard.obfuscate;

import java.io.*;

public interface MappingFileContentProvider {

    /**
     * Get reader for mapping file content.
     *
     * @return
     * @throws IOException
     */
    BufferedReader getReader() throws IOException;


    class LocalFileProvider implements MappingFileContentProvider {
        private final File mappingFile;

        public LocalFileProvider(File mappingFile) {
            this.mappingFile = mappingFile;
        }


        @Override
        public BufferedReader getReader() throws IOException {
            return new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(mappingFile), "UTF-8"));
        }
    }

    class StringContentProvider implements MappingFileContentProvider {
        private String content;

        public StringContentProvider(String content) {
            this.content = content;
        }

        @Override
        public BufferedReader getReader() {
            return new BufferedReader(new StringReader(this.content));
        }
    }
}
