import pandas as pd
import csv
# 1. Load the CSV file
df = pd.read_csv('Employees.csv')

# 2. Remove any duplicates
df = df.drop_duplicates()

# 3. Rename the column "Salary(USD)" to "Salary(EGP)"
df.rename(columns={"Salary(USD)": "Salary(EGP)"}, inplace=True)

# 4. Convert the salary from USD to EGP by multiplying the salary by 47.95
df["Salary(EGP)"] = df["Salary(EGP)"] * 47.95

# 5. Print some stats in the console
# Calculate average age
average_age = df["Age"].mean()

# Calculate median salary
median_salary = df["Salary(EGP)"].median()

# Calculate ratio between males and females employees
gender_ratio = df["Gender"].value_counts(normalize=True)

print("Average age:", average_age)
print("Median salary:", median_salary)
print("Ratio between males and females employees:")
print(gender_ratio)

# 6. Write the data to a new CSV file named "Task3.csv"
df.to_csv("Task3.csv", index=False)
