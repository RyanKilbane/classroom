package classroom
import java.time.LocalTime
class ClassroomSession(val start: String, val end: String){
    val start_time = LocalTime.parse(start)
    val end_time = LocalTime.parse(end)

    def <=(comp: ClassroomSession): Boolean = {
        return (comp.start_time.isAfter(end_time)
                | comp.start_time.equals(end_time))
    }

    def ==(comp: ClassroomSession): Boolean ={
        return (comp.start_time.equals(start_time)
                && comp.end_time.equals(end_time))
    }

    override def toString(): String = {
        return s"start: $start, end: $end"
    }
}