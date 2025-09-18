package leetcode.medium;

import java.util.*;

//https://leetcode.com/problems/design-task-manager/description/

//Time Complexity:
//        add: O(log n)
//        edit: O(log n)
//        rmv: O(1)
//        execTop: Amortized O(log n)
//
//Space Complexity:
//        O(n)
class TaskManager {

//    private static class Task is the cleanest option: encapsulated inside TaskManager, no wasted outer reference, and only visible where it’s needed.
    private static class Task{
        int userId;
        int taskId;
        int priority;

        Task(int u, int t, int p){
            userId=u;
            taskId=t;
            priority=p;
        }
    }
//    final because the reference itself cannot be reassigned after initialization but updates are allowed
    private final PriorityQueue<Task> pq;
    private final Map<Integer, Task> taskIdToTask;
    public TaskManager(List<List<Integer>> tasks) {
        taskIdToTask=new HashMap<>();

        pq=new PriorityQueue<>((a,b)->{
            if (a.priority != b.priority) {
                return Integer.compare(b.priority,a.priority);
            }
            return Integer.compare(b.taskId,a.taskId);
        });

        for(List<Integer> task:tasks){
            add(task.get(0),task.get(1),task.get(2));
        }

    }

    public void add(int userId, int taskId, int priority) {
        Task t=new Task(userId,taskId,priority);
        taskIdToTask.put(taskId,t);
        pq.add(t);
    }

    public void edit(int taskId, int newPriority) {
        Task oldTask=taskIdToTask.get(taskId);

//        if(oldTask==null) //useful in prod environments
//            return;

        Task updatedTask=new Task(oldTask.userId,taskId,newPriority);
        taskIdToTask.put(taskId,updatedTask);
        pq.add(updatedTask);
    }

    public void rmv(int taskId) {
//      Lazy removal =  don’t remove tasks from the heap right away; instead, mark them invalid and ignore them when popped later.
        taskIdToTask.remove(taskId);
    }

    public int execTop() {
        while(!pq.isEmpty()){
            Task t=pq.poll();
            Task valid=taskIdToTask.get(t.taskId);
            // valid must exist and have same priority (ensures it's the current entry).
            if(valid!=null && valid.priority==t.priority) {
                taskIdToTask.remove(t.taskId);
                return valid.userId; // use the current (valid) userId — t.userId may be stale
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        TaskManager tm = new TaskManager(Arrays.asList(
                Arrays.asList(1, 101, 10),
                Arrays.asList(2, 102, 20),
                Arrays.asList(3, 103, 15)
        ));

        tm.add(4,104,5);
        tm.edit(102,8);
        System.out.println("Expected output= 3, Actual output= "+tm.execTop());
        tm.rmv(101);
        tm.add(5, 105, 15);
        System.out.println("Expected output= 5, Actual output= "+ tm.execTop());
    }
}
