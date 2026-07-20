SELECT d.name Department, e.name Employee, e.salary Salary
FROM (
    SELECT *,
           DENSE_RANK() OVER (
               PARTITION BY departmentId
               ORDER BY salary DESC
           ) rnk
    FROM Employee
) e
JOIN Department d ON e.departmentId = d.id
WHERE rnk <= 3;