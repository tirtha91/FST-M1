#Readind CSV files
# Import pandas
import pandas

# Read the CSV file and store it into a DataFrame
dataframe = pandas.read_csv("sample.csv")

# Print the full data
print("Full Data: ")
print(dataframe)


print("Usernames:")
print(dataframe["Usernames"])

print("Username: ", dataframe["Usernames"][1], " | ", "Password: ", dataframe["Passwords"][1])

#Sort the Usernames column in ascending order
print("====================================")
print("Data sorted in ascending Usernames:")
print(dataframe.sort_values('Usernames'))

#Sort the Passwords column in descending order
print("====================================")
print("Data sorted in descending Passwords:")
print(dataframe.sort_values('Passwords', ascending=False))