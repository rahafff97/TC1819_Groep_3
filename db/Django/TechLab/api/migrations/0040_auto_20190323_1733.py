# Generated by Django 2.1.7 on 2019-03-23 16:33

import datetime
from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('api', '0039_auto_20190323_1726'),
    ]

    operations = [
        migrations.AlterField(
            model_name='borrowitem',
            name='borrow_date',
            field=models.DateTimeField(default=datetime.datetime(2019, 3, 23, 17, 33, 20, 453095)),
        ),
        migrations.AlterField(
            model_name='borrowitem',
            name='return_date',
            field=models.DateTimeField(default=datetime.datetime(2019, 3, 23, 17, 33, 20, 453095)),
        ),
        migrations.AlterField(
            model_name='item',
            name='description',
            field=models.CharField(default='', max_length=512),
        ),
    ]
