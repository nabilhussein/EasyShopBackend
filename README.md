# EasyShopBackend
Project Overview
-----------------

This project is an online shop with a front-end application already completed. However, the backend of the project requires additional implementation and modifications to support the following features:

1. User registration
2. Adding a new user
3. Admin Login
4. Adding a category as an admin
5. Retrieving newly added categories by ID
6. Deleting categories as an admin
7. Searching for products

Running the Project
-------------------

To run this project, you will need both the frontend and backend components. The frontend code is located in a separate folder within the project. Open the frontend code separately and launch the `index.html` file in a web browser to access the web application.

The project is divided into a few phases, each with specific tasks.

Phase 1
-------

In Phase 1, the class `MySqlCategoryDao` requires the implementation of the following methods:

- `getAllCategories()`: Retrieves all categories.
- `getById()`: Retrieves a category by its ID.
- `create()`: Creates a new category.
- `update()`: Updates an existing category.
- `delete()`: Deletes a category.

The class `CategoriesController` also requires the implementation of the following methods:

- `getAll()`: Retrieves all categories.
- `getById()`: Retrieves a category by its ID.
- `getProductsById()`: Retrieves products by category ID.
- `addCategory()`: Adds a new category.
- `updateCategory()`: Updates an existing category.
- `deleteCategory()`: Deletes a category.

The logic in these methods should utilize the methods provided by `MySqlCategoryDao`. Only administrators have the authority to add, update, and delete categories.

Phase 2
-------

Bug 1
-----
In Phase 2, there is a bug in the search functionality. The issue is located in the `search()` method of the `MySqlProductDao` class. The SQL query within the method is missing a clause for the maximum price. The query should be updated as follows:

```
"SELECT * FROM products " +
"WHERE (category_id = ? OR ? = -1) " +
"   AND (price <= ? OR ? = -1) " +
"   AND (price >= ? OR ? = -1) " +   
"   AND (color = ? OR ? = '') ";
```

To resolve this bug, the following lines should be added to the `search()` method to set the proper parameter for the SQL clause:

```
statement.setBigDecimal(3, maxPrice);
statement.setBigDecimal(4, maxPrice);
```

Bug 2
-----
The second bug occurs when the admin attempts to update a product, resulting in the creation of a new product instead. To fix this issue, the code inside the `ProductController` class, specifically the `updateProduct()` method, should be modified from:

```
productDao.create(product); // creates a new product
```

To:

```
productDao.update(id, product); // updates an existing product
```



Acknowledgments
----------------

Special thanks to Paul Kimball, and my friends for their valuable contributions and assistance throughout this project.

