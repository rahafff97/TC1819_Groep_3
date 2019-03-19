from django.db import models
import uuid


# Create your models here.
class User(models.Model):
    id = models.UUIDField(default=uuid.uuid4, editable=False, unique=True, primary_key=True)
    google_api_id = models.CharField(max_length=128)
    email = models.EmailField()


class Item(models.Model):
    id = models.UUIDField(default=uuid.uuid4, editable=False, unique=True, primary_key=True)


class Electronic(Item):
    title = models.CharField(max_length=128)
    writers = models.CharField(max_length=128)
    isbn = models.CharField(max_length=128)
    publisher = models.CharField(max_length=128)
    stock = models.IntegerField()


class Book(Item):
    product_id = models.CharField(max_length=64)
    manufacturer = models.CharField(max_length=128)
    category = models.CharField(max_length=128)
    name = models.CharField(max_length=128)
    stock = models.IntegerField()
    broken = models.IntegerField()


class BorrowItem(models.Model):
    item = models.ForeignKey(Item, related_name="borrow_item_item", on_delete=models.CASCADE)
    user = models.ForeignKey(User, related_name="borrow_item_item", on_delete=models.CASCADE)
    borrow_date = models.DateTimeField()
    return_date = models.DateTimeField()