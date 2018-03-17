package employee_importance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> m = new HashMap<>();
        for (Employee employee : employees)
            m.put(employee.id, employee);
        int r = 0;
        if(m.get(id) == null)return 0;
        Queue<Employee> q = new LinkedList<>();
        q.add(m.get(id));
        while(!q.isEmpty()){
            Employee e = q.poll();
            r+=e.importance;
            for (Integer subordinate : e.subordinates)
                q.add(m.get(subordinate));
        }
        return r;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
}