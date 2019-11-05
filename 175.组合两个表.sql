/* Write your PL/SQL query statement below */
SELECT FirstName "FirstName", LastName "LastName", City "City", State "State" 
FROM Person, Address 
WHERE Person.personId = Address.personId(+)