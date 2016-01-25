#version 140

in vec2 in_pos;

uniform vec2 u_position;
uniform vec2 u_size;

void main(void){
    vec2 center = u_position + u_size / 2;
    vec2 point = center + vec2(in_pos.x * u_size.x, in_pos.y * u_size.y);
    gl_Position = point;
}