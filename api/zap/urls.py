from django.urls import path

from .views import *

urlpatterns = [
    path('leds/', LedListCreateView.as_view(), name='led-list-create'),
    path('led/<int:pk>/', LedDetailView.as_view(), name='led-detail'),
    path('led/on/<int:pk>/', LedOnView.as_view(), name='led-on'),
    path('led/off/<int:pk>/', LedOffView.as_view(), name='led-off')
]
