from django.conf import settings
from django.http.response import JsonResponse
from django.views.generic import View

from api.models import (Book, Electronic)

import json


# Create your views here.
class GetAllItems(View):
    def get(self, request, *args, **kwargs):

        allBooks = Book.objects.all()
        allElectronics = Electronic.objects.all()

        

        return JsonResponse(json.loads('[{ "books": %s}, {"electronics" : %s}]' % (
            json.dumps([{
                'book_title': book.title,
                'book_description': book.description,
#                'book_image':  "%s%s%s" % (settings.BASE_URL, settings.MEDIA_ROOT, book.image.url) if book.image != '' else '',
                'book_image': settings.BASE_URL + settings.MEDIA_ROOT + book.image.url if book.image != '' else '',
                'writers': [{'name': writer.name} for writer in book.writers.all()],
                'isbn': book.isbn,
                'publisher': book.publisher.name,
                'is_available': True if book.stock > 0 else False,
                'borrow_days': book.borrow_days
                } for book in allBooks]),
            json.dumps([{
                'electronic_title' : electronic.name,
                'electronic_description' : electronic.description,
                'electionric_image': settings.BASE_URL + settings.MEDIA_ROOT + electronic.image.url if electronic.image != '' else '',
                'manufacturer': [{'name':manufacturer.name} for manufacturer in electronic.manufacturer.all()],
                'category': electronic.category.name,
                'is_available': True if electronic.stock > 0 else False,
                'borrow_days': electronic.borrow_days
                } for electronic in allElectronics]))),safe=False)
            
