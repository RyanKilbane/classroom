import org.junit.Test;
import junit.framework.TestCase
import org.junit.Assert._
import os.pwd
import readers.ReaderFactory, readers.JsonReader

class TestReader extends TestCase{
    val resources = pwd/"src"/"test"/"scala"/"resources"

    def testReaderFactoryJson{
        val json_file = resources/"classroom.json"
        val x = new ReaderFactory(json_file).makeReader
        println(x)
        x match{
            case p: JsonReader => assert(true)
            case _ => assert(false)
        }
    }

    def testJsonReader{
        val json_file = resources/"classroom.json"
        val x = new ReaderFactory(json_file).makeReader
    }
}