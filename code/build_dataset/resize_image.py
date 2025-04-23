from PIL import Image

image = Image.open('resize_images/tab8.png')
print(f"Original size : {image.size}") # 5464x3640

sunset_resized = image.resize((200, 200))
sunset_resized.save('./resize_images/tab8.png')