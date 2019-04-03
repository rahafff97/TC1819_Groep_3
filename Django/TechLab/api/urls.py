from django.contrib import admin
from django.conf.urls import url, include

from .views import (GetAllItems)

urlpatterns = [
    url('^items/$', GetAllItems.as_view()),
#    url('items/<filter>', GetFilteredItems),
]
