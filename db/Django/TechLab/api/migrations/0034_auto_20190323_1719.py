# Generated by Django 2.1.7 on 2019-03-23 16:19

import datetime
from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('api', '0033_auto_20190323_1716'),
    ]

    operations = [
        migrations.AlterField(
            model_name='borrowitem',
            name='borrow_date',
            field=models.DateTimeField(default=datetime.datetime(2019, 3, 23, 17, 19, 22, 846021)),
        ),
        migrations.AlterField(
            model_name='borrowitem',
            name='return_date',
            field=models.DateTimeField(default=datetime.datetime(2019, 3, 23, 17, 19, 22, 846021)),
        ),
    ]
