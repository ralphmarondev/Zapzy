from rest_framework import serializers

from .models import Led

class LedSerializer(serializers.ModelSerializer):
    class Meta:
        model = Led
        fields = '__all__'
        read_only_fields = ['created_at', 'updated_at']
