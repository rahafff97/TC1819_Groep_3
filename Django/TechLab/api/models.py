from django.db import models
from datetime import datetime
import uuid


# Create your models here.
class User(models.Model):
    id = models.UUIDField(default=uuid.uuid4, editable=False, unique=True, primary_key=True)
    google_api_id = models.CharField(max_length=128)
    email = models.EmailField()


class Item(models.Model):
    id = models.UUIDField(default=uuid.uuid4, editable=False, unique=True, primary_key=True)
     

class Book(Item):
    title = models.CharField(max_length=128)
    writers = models.CharField(max_length=128)
    isbn = models.CharField(max_length=128, default = "")
    publisher = models.CharField(max_length=128)
    stock = models.IntegerField(default=0)
    image = models.ImageField(null=True, blank=True, upload_to="Book_images/")


class Electronic(Item):
    product_id = models.CharField(max_length=64, default="")
    manufacturer = models.CharField(max_length=128, default="")
    category = models.CharField(max_length=128, default="")
    name = models.CharField(max_length=128, default="")
    stock = models.IntegerField(default=0)
    broken = models.IntegerField(default=0)
    image = models.ImageField(null=True, blank=True, upload_to="Electronics_images/")


class BorrowItem(models.Model):
    item = models.ForeignKey(Item, related_name="borrow_item_item", on_delete=models.CASCADE)
    user = models.ForeignKey(User, related_name="borrow_item_item", on_delete=models.CASCADE)
    borrow_date = models.DateTimeField(default=datetime.now())
    return_date = models.DateTimeField(default=datetime.now())
    hand_in_date = models.DateTimeField(default=datetime.now())