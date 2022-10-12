You are in charge of managing discounts for a big box super store.  After a successful year, it is your job to help reward our best customers with some discounts. In order to do so, we must validate that the discounts we have assigned to our customers are fair and valid.

You are given a list of DiscountAssignments that maps a DiscountId to a CustomerId. 

You are given a list of DiscountAssignments that maps a DiscountId to a CustomerId. 

You are also given a list of all Discounts that can be assigned to Customers and a list of all Customers that can have Discounts assigned to them.

All Discounts will have a unique DiscountId and all Customers will have a unique CustomerId. There will be no duplicated Discounts or Customers in their respective lists.

A customer can have multiple discounts assigned to them and the same Discount can be given to multiple customers. 

We must validate that:


1. No Customer has more than 3 discounts assigned to them

2. Every discount must be assigned to at least one customer

3. No Customer can have a total discount value more than 20% of their yearly spend

4. Customers must have a higher total discount value than other customers with lower yearly spends