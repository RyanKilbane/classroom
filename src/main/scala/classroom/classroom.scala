package classroom;

import java.time.LocalTime
import java.util.ArrayList;
import classroom.ClassroomSession;

class Classroom(val room_number: Int){
    var times: ArrayList[ClassroomSession] = new ArrayList()

    def load_times(all_times: ArrayList[ClassroomSession]): Option[Unit] = {
        for(i <- 0 until all_times.size()){
            if(this.times.isEmpty()){
                // If times are empty then we just take the most recent
                // time from all_times and add that
                this.times.add(all_times.get(0))
                all_times.remove(0)
                Some()
            }
            else{
                // Otherwise we want to find the first time that doesn't
                // conflict with any of the currently booked times
                val last_time = times.get(times.size() - 1);
                val x = findFirstNonConflict(last_time, all_times)
                x match{
                    case Some(i) => {
                        times.add(i)
                        all_times.remove(i)
                        Some()
                    }
                    case None => {
                        return None
                    }
                }
            }
        }
        return None
    }

    def findFirstNonConflict(session: ClassroomSession, all_times: ArrayList[ClassroomSession]): Option[ClassroomSession] = {
        for(i <- 0 until all_times.size()){
            if(session <= all_times.get(i)){
                return Some(all_times.get(i))
            }
        }
        return None
    }
}

