package readers

import scala.io.Source
import io.circe.parser

import os.Path
import cats.instances.stream

trait Read{
    def read: String
    def parse
}

class Reader(val path: String){
    def read: String = {
        return Source.fromFile(path).getLines().mkString
    }
}


class JsonReader(val json_path: String)
      extends Reader(json_path: String) with Read{
          val data = this.read
          def parse{
              parser.parse(data)
          }

          def makeClassSessions{

          }

          def makeClassrooms{

          }

          override def toString(): String = {
              data
          }
    }


class XmlReader(val xml_path: String)
      extends Reader(xml_path: String) with Read{
          val data = this.read
          def parse{

          }
      }


class ReaderFactory(val file_path: Path){
    val file_type = file_path.last.split("\\.").last
    println(file_type)
    def makeReader: Reader = {
        file_type match{
            case "json" => new JsonReader(file_path.toString())
            case "xml" => new XmlReader(file_path.toString())
        }
    }
}
