//even this took quiet a bit of help from gpt yet only 
// 658 / 663 testcases passed
// time limit exceeded

// class TaskManager {
//     List<List<Integer>> tasks;

//     public TaskManager(List<List<Integer>> tasks) {
//         this.tasks = tasks;
//     }

//     public void add(int userId, int taskId, int priority) {
//         this.tasks.add(Arrays.asList(userId, taskId, priority));
//     }

//     public void edit(int taskId, int newPriority) {
//         this.tasks.forEach(t -> {
//             if (t.get(1) == taskId)
//                 t.set(2, newPriority);
//         });
//     }

//     public void rmv(int taskId) {
//         this.tasks.removeIf(t -> t.get(1) == taskId);
//     }

//     public int execTop() {
//         if (tasks.isEmpty()) {
//             return -1;
//         }

//         int maxp = -1;
//         List<Integer> hightask = null;

//         for (List<Integer> t : tasks) {
//             if (t.get(2) > maxp) {
//                 maxp = t.get(2);
//                 hightask = t;
//             }
//             if (t.get(2) == maxp) {
//                 if (t.get(1) > hightask.get(1)) {
//                     maxp = t.get(2);
//                     hightask = t;
//                 }
//             }
//         }

//         int userId = hightask.get(0);
//         this.tasks.remove(hightask);
//         return userId;

//     }
// }

// oh well gpt was able to do pass all testcases in the end.
// no logic of mine was used, utterly failed.
