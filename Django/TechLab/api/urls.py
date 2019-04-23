from django.contrib import admin
from django.conf.urls import url, include

from .views import (GetAllItems, GetFilteredItems, AdminLogin)

urlpatterns = [
    url(r'^items/$', GetAllItems.GetAllItems.as_view()),
#    url('items/(?<filter>)', GetFilteredItems),
    url(r'^login/', AdminLogin.Login.as_view()),
]
