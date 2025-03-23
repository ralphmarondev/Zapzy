from django.shortcuts import get_object_or_404
from rest_framework import status
from rest_framework.response import Response
from rest_framework.views import APIView

from zap.serializers import LedSerializer
from .models import Led

class LedListCreateView(APIView):
    def get(self, request):
        leds = Led.objects.all()
        serializer = LedSerializer(leds, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = LedSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

class LedDetailView(APIView):
    def get(self, request, pk):
        led = get_object_or_404(Led, pk=pk)
        serializer = LedSerializer(led)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def patch(self, request, pk):
        led = get_object_or_404(led, pk=pk)
        serializer = LedSerializer(led, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk):
        led = get_object_or_404(Led, pk=pk)
        led.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

class LedOnView(APIView):
    def patch(self, request, pk):
        led = get_object_or_404(Led, pk=pk)
        led.status = True
        led.save()
        return Response({'message': f'Led {led.name} turned ON'}, status=status.HTTP_200_OK)

class LedOffView(APIView):
    def patch(self, request, pk):
        led = get_object_or_404(Led, pk=pk)
        led.status = False
        led.save()
        return Response({'message': f'Led {led.name} turned OFF'}, status=status.HTTP_200_OK)
