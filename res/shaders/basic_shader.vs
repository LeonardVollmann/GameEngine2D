#version 330 core

layout(location = 0) in vec3 in_position;
layout(location = 1) in vec2 in_texCoord;

out vec3 pass_color;
out vec2 pass_texCoord;

uniform float u_clampValue;

void main()
{
	pass_color = clamp(in_position, 0, u_clampValue);
	pass_texCoord = in_texCoord;

	gl_Position = vec4(in_position, 1.0f);
}