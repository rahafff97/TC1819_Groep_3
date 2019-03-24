from django.contrib import admin

from .models import (User, Book, BorrowItem, Electronic)

# Register your models here.


admin.site.register(User)
admin.site.register(Book)
admin.site.register(BorrowItem)
admin.site.register(Electronic)