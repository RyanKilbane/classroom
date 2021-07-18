import classroom.Classroom;
import classroom.ClassroomSession;

import org.junit.Test;
import junit.framework.TestCase
import org.junit.Assert._

import java.time.LocalTime;
import java.util.ArrayList

class TestClassroom extends TestCase{

        var times: ArrayList[ClassroomSession] = new ArrayList();
        var t1 = new ClassroomSession("10:00:00", "11:00:00")
        var t2 = new ClassroomSession("11:00:00", "12:00:00")
        times.add(t1);
        times.add(t2);

    def testLoadTime{
        var classroom = new Classroom(10);
        classroom.load_times(times);
        assert(classroom.times.get(0) == t1)
    }

    def testFindNonConfict{
        var classroom = new Classroom(10);
        var x = classroom.findFirstNonConflict(t1, times);
        assert(x.get == t2)
    }

    def testFindNonConflictWithNone{
        var classroom = new Classroom(10);
        var x = classroom.findFirstNonConflict(t2, times);
        assert(x == None)
    }

    def testPopulate{
        var classes: ArrayList[ClassroomSession] = new ArrayList();
        var classrooms: ArrayList[Classroom] = new ArrayList();
        classrooms.add(new Classroom(1))
        classrooms.add(new Classroom(2))

        classes.add(new ClassroomSession("09:00:00", "10:00:00"))
        classes.add(new ClassroomSession("09:00:00", "11:00:00"))
        classes.add(new ClassroomSession("10:00:00", "11:00:00"))

        for(i <- 0 until classrooms.size()){
            var classroom = classrooms.get(i)
            classroom.load_times(classes)
            
        }
        println(classrooms.get(0).times)
        println(classrooms.get(1).times)

        assert(classrooms.get(0).times.get(0) == new ClassroomSession("09:00:00", "10:00:00"))
        assert(classrooms.get(0).times.get(1) == new ClassroomSession("10:00:00", "11:00:00"))
        assert(classrooms.get(1).times.get(0) == new ClassroomSession("09:00:00", "11:00:00"))
    }

}