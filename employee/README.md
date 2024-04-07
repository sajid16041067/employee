Empoyee management ..

endpoint url..
1.GET all empoyees
http://localhost:8086/api/employees/
2.GET by id
http://localhost:8086/api/employees/{id} ../1
3. POST create employees
http://localhost:8086/api/employees/

PayLoad:
{
  "name": "Sajid",
  "salary": 30000.0
 
}

4.PUT update a employee by id
http://localhost:8086/api/employees/{id} ../1

PayLoad:
{
  "name": "Sajid",
  "salary": 40000.0
 
}

5.DELETE by id 
http://localhost:8086/api/employees/{id} ../1



**VALIDATION****
1.salary should not be negtaive 
2.name can not be empty

**EXCEPTION**
1.empoyee not found exception ocurrs on get by id, update by id, delete by id, get by id ...if id is not present 

**DATA PERSISTENCE****
i have used spring data jpa for storing and managing data





