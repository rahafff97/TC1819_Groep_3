from django.db import models
from datetime import datetime
from django.conf import settings
import uuid


# Create your models here.
class User(models.Model):
    def __str__(self):
        return self.email
    id = models.UUIDField(default=uuid.uuid4, editable=False, unique=True, primary_key=True)
    google_api_id = models.CharField(max_length=128)
    email = models.EmailField()


class Item(models.Model):
    id = models.UUIDField(default=uuid.uuid4, editable=False, unique=True, primary_key=True)
    borrow_days = models.IntegerField(default=0)
    description = models.CharField(max_length=2048, default="")
    image = models.ImageField(blank=True, upload_to='static')


class Writer(models.Model):
    def __str__(self):
        return self.name
    name = models.CharField(max_length=128, default="")


class Category(models.Model):
    def __str__(self):
        return self.name
    name = models.CharField(max_length=128, default="")


class Manufacturer(models.Model):
    def __str__(self):
        return self.name
    name = models.CharField(max_length=128, default="")


class Publisher(models.Model):
    def __str__(self):
        return self.name
    name = models.CharField(max_length=128, default="")


class Book(Item):
    def __str__(self):
        return self.title
    title = models.CharField(max_length=128)
    writers = models.ManyToManyField(Writer, blank=True)
    isbn = models.CharField(max_length=128, default = "")
    publisher = models.ForeignKey(Publisher, on_delete=models.CASCADE)
    stock = models.IntegerField(default=0)


class Electronic(Item):
    def __str__(self):
        return self.name
    product_id = models.CharField(max_length=64, default="")
    manufacturer = models.ManyToManyField(Manufacturer, blank=True)
    category = models.ForeignKey(Category, on_delete=models.CASCADE)
    name = models.CharField(max_length=128, default="")
    stock = models.IntegerField(default=0)
    broken = models.IntegerField(default=0)


class BorrowItem(models.Model):
    item = models.ForeignKey(Item, related_name="borrow_item_item", on_delete=models.CASCADE)
    user = models.ForeignKey(User, related_name="borrow_item_item", on_delete=models.CASCADE)
    borrow_date = models.DateTimeField(default=datetime.now())
    return_date = models.DateTimeField(default=datetime.now())
    hand_in_date = models.DateTimeField(blank=True)
