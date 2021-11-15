#Fruit Shop
fruit_shop = {
    "apple": 5,
    "banana": 24,
    "orange": 45,
    "peaches": 5
}

key_to_check = input("What are you looking for? ").lower()

if(key_to_check in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")